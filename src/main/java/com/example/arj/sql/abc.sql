INSERT INTO arj.account (id, password, username) VALUES (1, 'a', 'a');
INSERT INTO arj.account (id, password, username) VALUES (2, 'b', 'b');

INSERT INTO arj.position (id, can_create, can_end, code, hierarchy, name, is_valid) VALUES (1, true, true, 'a', 1, 'a', true);
INSERT INTO arj.position (id, can_create, can_end, code, hierarchy, name, is_valid) VALUES (2, true, true, 'b', 2, 'b', true);

INSERT INTO arj.employee (id, is_valid, name, account_id, position_id) VALUES (1, true, 'gauri', 1, 1);
INSERT INTO arj.employee (id, is_valid, name, account_id, position_id) VALUES (2, true, 'vaibhav', 2, 2);

INSERT INTO arj.make (id, value, is_valid) VALUES (1, '1', true);
INSERT INTO arj.make (id, value, is_valid) VALUES (2, '2', true);
INSERT INTO arj.make (id, value, is_valid) VALUES (3, '3', true);
INSERT INTO arj.make (id, value, is_valid) VALUES (4, '4', true);
