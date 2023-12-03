-- Insert data into the 'category' table
INSERT INTO category (category_name)
VALUES ('Backend Development'),
       ('Frontend Development'),
       ('Database Management');

-- Insert data into the 'project' table
INSERT INTO project (project_name, estimated_hours, actual_hours, difficulty, notes)
VALUES ('Build Backend', 100.00, 120.00, 3, 'Backend development for the web app'),
       ('Build Frontend', 80.00, 90.00, 2, 'Frontend development for the web app'),
       ('Database Setup', 20.00, 25.00, 1, 'Setting up the database service');

-- Insert data into the 'material' table
-- For 'Build Backend' project
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (1, 'Server Hosting', 2, 200.00),
       (1, 'Software Licenses', 5, 500.00);

-- For 'Build Frontend' project
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (2, 'Frontend Framework', 1, 0.00),
       (2, 'Design Assets', 3, 150.00);

-- For 'Database Setup' project
INSERT INTO material (project_id, material_name, num_required, cost)
VALUES (3, 'Database Service Subscription', 1, 50.00);

-- Insert data into the 'step' table
-- For 'Build Backend' project
INSERT INTO step (project_id, step_text, step_order)
VALUES (1, 'Design API endpoints', 1),
       (1, 'Implement Authentication', 2),
       (1, 'Optimize Database Queries', 3);

-- For 'Build Frontend' project
INSERT INTO step (project_id, step_text, step_order)
VALUES (2, 'Create UI Mockups', 1),
       (2, 'Develop User Interface', 2),
       (2, 'Integrate with Backend', 3);

-- For 'Database Setup' project
INSERT INTO step (project_id, step_text, step_order)
VALUES (3, 'Choose Database System', 1),
       (3, 'Set Up Tables and Schema', 2),
       (3, 'Test Database Connectivity', 3);

-- Insert data into the 'project_category' table to associate projects with categories
-- For 'Build Backend' project
INSERT INTO project_category (project_id, category_id)
VALUES (1, 1);

-- For 'Build Frontend' project
INSERT INTO project_category (project_id, category_id)
VALUES (2, 2);

-- For 'Database Setup' project
INSERT INTO project_category (project_id, category_id)
VALUES (3, 3);

commit;
