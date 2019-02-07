INSERT INTO user (name) VALUES ('John Smith');
INSERT INTO user (name) VALUES ('Alan Fox');
INSERT INTO user (name) VALUES ('Josh Bow');
INSERT INTO user (name) VALUES ('Tim Odersky');

INSERT INTO task (name, status, severity, created_date, user_id) VALUES ('Task 1', 'STATUS_1', 'LOW', now(), (SELECT id from user WHERE name='John Smith'));
INSERT INTO task (name, status, severity, created_date, user_id) VALUES ('Task 2', 'STATUS_2', 'MEDIUM', now(), (SELECT id from user WHERE name='John Smith'));
INSERT INTO task (name, status, severity, created_date, user_id) VALUES ('Task 3', 'STATUS_3', 'HIGH', now(), (SELECT id from user WHERE name='John Smith'));

INSERT INTO comment (text, created_date, task_id) VALUES ('First Comment', now(), (SELECT id from task WHERE id=1));
INSERT INTO comment (text, created_date, task_id) VALUES ('SecondComment', now(), (SELECT id from task WHERE id=1));