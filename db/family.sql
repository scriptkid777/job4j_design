CREATE TABLE car_driver (
                            id SERIAL PRIMARY KEY,
                            car_id INTEGER REFERENCES car(id),
                            driver_id INTEGER REFERENCES driver(id)
);