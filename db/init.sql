-- Create the User table
CREATE TABLE "user" (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    dni INT NOT NULL UNIQUE
);

-- Create the Room table
CREATE TABLE room (
    room_id SERIAL PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    bed_count INT NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('AVAILABLE', 'OCCUPIED', 'MAINTENANCE'))
);

-- Create the Booking table
CREATE TABLE reserve (
    reserve_id SERIAL PRIMARY KEY,
    price DOUBLE PRECISION NOT NULL,
    room_id INT NOT NULL,
    user_id INT NOT NULL,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room(room_id),
    FOREIGN KEY (user_id) REFERENCES "user"(user_id)
);