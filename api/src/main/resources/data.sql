INSERT INTO user(user_type, id, name, uid) VALUES ('user', 1, 'Francisco', 'abc')
INSERT INTO user(user_type, id, name, uid) VALUES ('admin', 2, 'Francisco', 'abcd')
INSERT INTO user(user_type, id, name, uid) VALUES ('user', 3, 'Roque', 'roque')
INSERT INTO tag(id, name) VALUES (1, 'tag1')
INSERT INTO tag(id, name) VALUES (2, 'tag2')
INSERT INTO topic(id, description) VALUES (1, 'topic1')
INSERT INTO topic(id, description) VALUES (2, 'topic2')
INSERT INTO post(id, content, name, topic_id, user_id) VALUES (1, 'content1', 'post1', 1, 1)
INSERT INTO post(id, content, name, topic_id, user_id) VALUES (2, 'content2', 'post2', 2, 1)
INSERT INTO topic_tags(topic_id, tag_id) VALUES (1, 1)
INSERT INTO topic_tags(topic_id, tag_id) VALUES (1, 2)
INSERT INTO topic_tags(topic_id, tag_id) VALUES (2, 1)
INSERT INTO user_comments(user_id, post_id) VALUES (1,1)
INSERT INTO user_comments(user_id, post_id) VALUES (1,2)