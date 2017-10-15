CREATE SCHEMA IF NOT EXISTS trackq;

CREATE TABLE IF NOT EXISTS trackq.users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL UNIQUE,
  email VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  enabled BIT DEFAULT 1
);


CREATE TABLE IF NOT EXISTS trackq.roles (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  rolename VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS trackq.projects (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  project_name VARCHAR(30) NOT NULL,
  description VARCHAR(30),
  project_id BIGINT NOT NULL UNIQUE,
  FOREIGN KEY (project_id) REFERENCES projects(id),
  status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS trackq.issues (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  project_id BIGINT NOT NULL UNIQUE,
  FOREIGN KEY (project_id) REFERENCES projects(id),
  status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS trackq.user_to_role (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL, role_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS  trackq.user_email_confirmation (
  user_id BIGINT NOT NULL UNIQUE,
  confirmation_id VARCHAR(255),
  expiration_timestamp timestamp,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS trackq.issue_to_assignee (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL, issue_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (issue_id) REFERENCES issues(id)
);

CREATE TABLE IF NOT EXISTS trackq.issue_to_reporter (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL, issue_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (issue_id) REFERENCES issues(id)
);

CREATE TABLE IF NOT EXISTS trackq.user_to_project (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL, project_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (project_id) REFERENCES projects(id)
);