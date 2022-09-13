
CREATE TABLE IF NOT EXISTS quiz.question_levels
(
    id serial NOT NULL,
    name text,
    created timestamp NOT NULL,
    modified timestamp NOT NULL,
    is_delete boolean DEFAULT false,
    CONSTRAINT pk_question_levels PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS quiz.question_types
(
    id serial NOT NULL,
    name text,
    created timestamp NOT NULL,
    modified timestamp NOT NULL,
    is_delete boolean DEFAULT false,
    CONSTRAINT pk_question_types PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS quiz.questions
(
    id serial NOT NULL,
    name text,
    question_type_id integer,
    timeout int DEFAULT 30,
    score int default 5,
    created timestamp,
    modified timestamp,
    is_delete boolean DEFAULT false,
    question_level_id integer,
    status boolean DEFAULT false,
    CONSTRAINT pk_questions PRIMARY KEY (id),
    CONSTRAINT fk_questions_question_levels FOREIGN KEY (question_level_id)
        REFERENCES quiz.question_levels (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_questions_question_types FOREIGN KEY (question_type_id)
        REFERENCES quiz.question_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS quiz.answers
(
    id serial NOT NULL,
    name text,
    score int DEFAULT 0,
    created timestamp ,
    modified timestamp ,
    is_delete boolean DEFAULT false,
    is_correct boolean DEFAULT false,
    question_id integer,
    CONSTRAINT pk_answers PRIMARY KEY (id),
    CONSTRAINT fk_answers_questions FOREIGN KEY (question_id)
        REFERENCES quiz.questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);




CREATE TABLE IF NOT EXISTS quiz.quiz_levels
(
    id serial NOT NULL,
    name text,
    created timestamp,
    modified timestamp,
    is_delete boolean DEFAULT false,
    CONSTRAINT pk_quiz_levels PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS quiz.quizzes
(
    id serial NOT NULL,
    name text,
    description text,
    quiz_level_id integer,
    created timestamp,
    modified timestamp,
    is_delete boolean DEFAULT false,
    status boolean,
    CONSTRAINT pk_quizzes PRIMARY KEY (id),
    CONSTRAINT fk_quizzes_quiz_levels FOREIGN KEY (quiz_level_id)
        REFERENCES quiz.quiz_levels (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



CREATE TABLE IF NOT EXISTS quiz.quiz_questions
(
    id serial NOT NULL,
    quiz_id integer,
    question_id integer,
    CONSTRAINT pk_quiz_questions PRIMARY KEY (id),
    CONSTRAINT fk_quiz_questions_questions FOREIGN KEY (question_id)
        REFERENCES quiz.questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_quiz_questions_quizzes FOREIGN KEY (quiz_id)
        REFERENCES quiz.quizzes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS quiz.user_positions
(
    id serial NOT NULL,
    name text,
    created timestamp NOT NULL,
    modified timestamp NOT NULL,
    is_delete boolean DEFAULT false,
    CONSTRAINT pk_user_positions PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS quiz.user_roles
(
    id serial NOT NULL,
    name text,
    created timestamp NOT NULL,
    modified timestamp NOT NULL,
    is_delete boolean DEFAULT false,
    CONSTRAINT pk_user_roles PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS quiz.users
(
    id serial NOT NULL,
    first_name varchar(50),
    last_name varchar(50),
    phone varchar(200),
    email varchar(200),
    password text,
    user_role_id integer,
    user_position_id integer,
    created timestamp without time zone,
    modified timestamp without time zone,
    status boolean default false,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT fk_users_user_positions FOREIGN KEY (user_position_id)
        REFERENCES quiz.user_positions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_users_user_roles FOREIGN KEY (user_role_id)
        REFERENCES quiz.user_roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS quiz.user_quizzes
(
    id serial NOT NULL,
    quiz_id integer,
    user_id integer,
    CONSTRAINT pk_user_quiz PRIMARY KEY (id),
    CONSTRAINT fk_user_quiz_quizs FOREIGN KEY (user_id)
        REFERENCES quiz.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_quiz_questions_quizzes FOREIGN KEY (quiz_id)
        REFERENCES quiz.quizzes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


















