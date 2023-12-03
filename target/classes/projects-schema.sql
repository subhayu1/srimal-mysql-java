-- Drop the 'project_category' table if it exists
DROP TABLE IF EXISTS project_category;

-- Drop the 'material' table if it exists
DROP TABLE IF EXISTS material;

-- Drop the 'step' table if it exists
DROP TABLE IF EXISTS step;

-- Drop the 'project' table if it exists
DROP TABLE IF EXISTS project;

-- Drop the 'category' table if it exists
DROP TABLE IF EXISTS category;

-- Create the 'category' table
CREATE TABLE category (
                          category_id INT NOT NULL PRIMARY KEY,
                          category_name VARCHAR(128) NOT NULL
);

-- Create the 'project' table
CREATE TABLE project (
                         project_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         project_name VARCHAR(128) NOT NULL,
                         estimated_hours DECIMAL(7,2),
                         actual_hours DECIMAL(7,2),
                         difficulty INT,
                         notes TEXT
);

-- Create the 'material' table
CREATE TABLE material (
                          material_id INT NOT NULL PRIMARY KEY,
                          project_id INT NOT NULL,
                          material_name VARCHAR(128) NOT NULL,
                          num_required INT,
                          cost DECIMAL(7,2),
                          FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE
);

-- Create the 'step' table
CREATE TABLE step (
                      step_id INT NOT NULL PRIMARY KEY,
                      project_id INT NOT NULL,
                      step_text TEXT NOT NULL,
                      step_order INT NOT NULL,
                      FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE
);

-- Create the 'project_category' table
CREATE TABLE project_category (
                                  project_id INT NOT NULL,
                                  category_id INT NOT NULL,
                                  PRIMARY KEY (project_id, category_id),
                                  FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE,
                                  FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE CASCADE
);
