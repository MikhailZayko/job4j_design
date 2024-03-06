INSERT INTO roles (role_name) VALUES 
('Admin'),
('Moderator'),
('User');
INSERT INTO users (username, email, role_id) VALUES
('admin', 'admin@example.com', 1),
('moderator', 'moderator@example.com', 2),
('user1', 'user1@example.com', 3),
('user2', 'user2@example.com', 3);
INSERT INTO rules (rule_name) VALUES 
('edit_users'),
('edit_items'),
('view_items');
INSERT INTO roles_rules (role_id, rule_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3);
INSERT INTO categories (category_name) VALUES 
('Hardware'),
('Software'),
('Networking');
INSERT INTO states (state_name) VALUES 
('Open'),
('In Progress'),
('Resolved'),
('Closed');
INSERT INTO items (title, user_id, category_id, state_id) VALUES
('Заявка 1', 1, 1, 1),
('Заявка 2', 2, 2, 1),
('Заявка 3', 3, 3, 1);
INSERT INTO comments (comment_text, item_id) VALUES
('Первый комментарий к заявке 1', 1),
('Второй комментарий к заявке 1', 1),
('Комментарий к заявке 2', 2);
INSERT INTO attachs (attach_path, item_id) VALUES
('path/to/file1', 1),
('path/to/file2', 1),
('path/to/file3', 2);
