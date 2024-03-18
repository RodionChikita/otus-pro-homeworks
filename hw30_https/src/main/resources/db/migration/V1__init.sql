create table messages (
    id bigserial primary key,
    text_message varchar(255),
    created_at timestamp
);

insert into messages (text_message, created_at) values
('Message 1', now()),
('Message 2', now()),
('Message 3', now());