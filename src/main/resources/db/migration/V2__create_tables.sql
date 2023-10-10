-- Create the Desk table
CREATE TABLE IF NOT EXISTS desk
(
    desk_id VARCHAR(255) PRIMARY KEY NOT NULL,
    occupancy_status VARCHAR(255),
    emp_id           INT
    );

-- Create the Request table
CREATE TABLE IF NOT EXISTS request
(
    request_id   BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    status       VARCHAR(255),
    from_desk_id VARCHAR(255),
    to_desk_id   VARCHAR(255),
    description  VARCHAR(255),
    emp_id       INT
    );

CREATE  INDEX  idx_emp_id ON employee (emp_id);
CREATE INDEX idx_from_desk ON Desk (desk_id);
CREATE INDEX idx_to_desk ON Desk (desk_id);

ALTER TABLE desk
    ADD CONSTRAINT fk_emp_id FOREIGN KEY (emp_id) REFERENCES employee (emp_id);

ALTER TABLE request
ADD CONSTRAINT fk_from_desk FOREIGN KEY (from_desk_id) REFERENCES desk (desk_id),
ADD CONSTRAINT fk_to_desk FOREIGN KEY (to_desk_id) REFERENCES desk (desk_id),
ADD CONSTRAINT fk_id_emp FOREIGN KEY (emp_id) REFERENCES employee (emp_id);