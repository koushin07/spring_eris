CREATE TABLE blacklists (
    access_token VARCHAR(225),
    refresh_token VARCHAR(225)
);
------------- START OF ADMINISTRATIVE AREA -----------------------
CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_type VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE provinces (
    province_id SERIAL PRIMARY KEY,
    province_name VARCHAR(225) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE municipalities (
    municipality_id SERIAL PRIMARY KEY,
    municipality_name VARCHAR(225) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    province_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (province_id) REFERENCES provinces(province_id)
);

CREATE TABLE assign_offices (
    assign_office_id SERIAL PRIMARY KEY,
    province_id BIGINT,
    municipality_id BIGINT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (province_id) REFERENCES provinces(province_id),
    FOREIGN KEY (municipality_id) REFERENCES municipalities(municipality_id)
);

CREATE TABLE offices (
    office_id SERIAL PRIMARY KEY,
    role_id INT NOT NULL,
    assign_office_id BIGINT NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (assign_office_id) REFERENCES assign_offices(assign_office_id)
);

CREATE TABLE personnel (
    personnel_id SERIAL PRIMARY KEY,
    first_name VARCHAR(225) NOT NULL,
    last_name VARCHAR(225) NOT NULL,
    suffix VARCHAR(225),
    middle_name VARCHAR(225),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE office_personnel (
    office_personnel_id SERIAL PRIMARY KEY,
    office_id BIGINT NOT NULL,
    personnel_id BIGINT NOT NULL,
    is_active INT DEFAULT 1,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (office_id) REFERENCES offices(office_id),
    FOREIGN KEY (personnel_id) REFERENCES personnel(personnel_id)
);
------------- END OF ADMINISTRATIVE AREA -----------------------

---------- START OF EQUIPMENT MANAGEMENT AREA ------------------

CREATE TABLE equipment (
    equipment_id SERIAL PRIMARY KEY,
    equipment_name VARCHAR(225) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE equipment_attributes (
    equipment_attribute_id SERIAL PRIMARY KEY,
    serial_number VARCHAR(225) NOT NULL,
    asset_description VARCHAR(225),
    code VARCHAR(50) NOT NULL,
    model_number VARCHAR(225) NOT NULL,
    unit VARCHAR(50) NOT NULL,
    asset_id INT NOT NULL,
    category VARCHAR(50) NOT NULL,
    remarks VARCHAR(225),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE equipment_owner (
    equipment_owner_id SERIAL PRIMARY KEY,
    office_id BIGINT NOT NULL,
    equipment_id BIGINT NOT NULL,
    equipment_attribute_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (office_id) REFERENCES offices(office_id),
    FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id),
    FOREIGN KEY (equipment_attribute_id) REFERENCES equipment_attributes(equipment_attribute_id)
);

CREATE TABLE equipment_details (
    equipment_detail_id SERIAL PRIMARY KEY,
    equipment_owner_id BIGINT NOT NULL,
    serviceable INT NOT NULL DEFAULT 0,
    poor INT NOT NULL DEFAULT 0,
    unserviceable INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (equipment_owner_id) REFERENCES equipment_owner(equipment_owner_id)
);

---------- END OF EQUIPMENT MANAGEMENT AREA ------------------

-------START OF TRANSACTION MANAGEMENT AREA ------------------

CREATE TABLE borrowings (
    borrowing_id SERIAL PRIMARY KEY,
    borrower BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (borrower) REFERENCES offices(office_id)
);

CREATE TABLE situational_reports (
    report_id SERIAL PRIMARY KEY,
    file_name VARCHAR(50) NOT NULL,
    file_path VARCHAR(225) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE incidents (
    incident_id SERIAL PRIMARY KEY,
    report_id BIGINT,
    incident_title VARCHAR(50) NOT NULL,
    incident_summary VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (report_id) REFERENCES situational_reports(report_id)
);

CREATE TABLE borrowing_details (
    borrowing_detail_id SERIAL PRIMARY KEY,
    incident_id BIGINT NOT NULL,
    equipment_owner_id BIGINT NOT NULL,
    borrowing_id BIGINT NOT NULL,
    quantity INT,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    decided_at TIMESTAMP,
    received_at TIMESTAMP,
    returned_at TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (incident_id) REFERENCES incidents(incident_id),
    FOREIGN KEY (equipment_owner_id) REFERENCES equipment_owner(equipment_owner_id),
    FOREIGN KEY (borrowing_id) REFERENCES borrowings(borrowing_id)
);

-------END OF TRANSACTION MANAGEMENT AREA ------------------
