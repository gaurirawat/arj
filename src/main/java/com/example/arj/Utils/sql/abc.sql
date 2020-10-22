INSERT INTO arj.account (id, password, username) VALUES (1, 'a', 'a');
INSERT INTO arj.account (id, password, username) VALUES (2, 'b', 'b');
INSERT INTO arj.account (id, password, username) VALUES (3, 'drogo', 'drogo');

INSERT INTO arj.item (id, is_valid, name, service_id, uom_id) VALUES (1, true, 'donut', 1, 1);
INSERT INTO arj.item (id, is_valid, name, service_id, uom_id) VALUES (2, true, 'chocolava', 1, 1);
INSERT INTO arj.item (id, is_valid, name, service_id, uom_id) VALUES (3, true, 'wine', 2, 2);
INSERT INTO arj.item (id, is_valid, name, service_id, uom_id) VALUES (4, true, 'mojito', 2, 2);

INSERT INTO arj.make (id, is_valid, value) VALUES (1, true, '1');
INSERT INTO arj.make (id, is_valid, value) VALUES (2, false, '2');
INSERT INTO arj.make (id, is_valid, value) VALUES (3, true, '3');
INSERT INTO arj.make (id, is_valid, value) VALUES (4, false, '4');
INSERT INTO arj.make (id, is_valid, value) VALUES (5, true, 'meter');
INSERT INTO arj.make (id, is_valid, value) VALUES (6, true, 'kilogram');
INSERT INTO arj.make (id, is_valid, value) VALUES (7, true, 'gram');
INSERT INTO arj.make (id, is_valid, value) VALUES (8, true, '5');
INSERT INTO arj.make (id, is_valid, value) VALUES (9, true, 'make1');

INSERT INTO arj.origin (id, is_valid, value) VALUES (1, true, 'origin1');
INSERT INTO arj.origin (id, is_valid, value) VALUES (2, true, 'origin2');

INSERT INTO arj.service (id, code, is_valid, name) VALUES (1, 'food', true, 'food');
INSERT INTO arj.service (id, code, is_valid, name) VALUES (2, 'drink', true, 'drink');

INSERT INTO arj.uom (id, is_valid, unit) VALUES (1, true, 'grams');
INSERT INTO arj.uom (id, is_valid, unit) VALUES (2, true, 'litres');

INSERT INTO arj.position (id, can_create, can_end, code, hierarchy, is_valid, name) VALUES (1, true, true, 'a', 1, true, 'a');
INSERT INTO arj.position (id, can_create, can_end, code, hierarchy, is_valid, name) VALUES (2, true, true, 'b', 2, true, 'b');

INSERT INTO arj.employee (id, is_valid, name, account_id, position_id) VALUES (1, true, 'gauri', 1, 1);
INSERT INTO arj.employee (id, is_valid, name, account_id, position_id) VALUES (2, true, 'vaibhav', 2, 2);
INSERT INTO arj.employee (id, is_valid, name, account_id, position_id) VALUES (3, true, 'smit', 3, 1);

INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (1, 'p1', true, 'project1', 2);
INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (2, 'p2', true, 'project2', 2);
INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (3, 'p3', true, 'project3', 2);
INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (4, 'p4', true, 'project4', 2);
INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (5, 'p4', true, 'project4', 2);
INSERT INTO arj.project (id, code, is_valid, name, manager_id) VALUES (6, 'p4', true, 'project4', 2);

INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (1, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (1, 3);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (2, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (2, 3);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (3, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (3, 3);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (4, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (4, 3);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (5, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (5, 3);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (6, 1);
INSERT INTO arj.project_pe_mapping (project_id, employee_id) VALUES (6, 3);

INSERT INTO arj.material_request (id, area_floor, current_level_of_hierarchy, do_cancellation, do_completion, do_creation, do_required_delivery, instruction, remark, status, project_id, raised_by_id, service_id) VALUES (1, 'floor1', 2, null, null, '2020-10-22', '2021-10-22', 'NONE', null, 'PENDING', 1, 1, 1);
