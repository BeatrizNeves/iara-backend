-- popula tabela achievement

INSERT INTO achievement (name, description)
VALUES ("O início", "Você esteve ativo por 3 dias seguidos!");

INSERT INTO achievement (name, description)
VALUES ("esforçado!", "Você esteve ativo por 10 dias seguidos!");

INSERT INTO achievement (name, description)
VALUES ("gênio!", "Você esteve ativo por 50 dias seguidos!");

INSERT INTO achievement (name, description)
VALUES ("Primeira de muitas!", "Você concluiu sua primeira atividade!");

INSERT INTO achievement (name, description)
VALUES ("O fim da primeira jornada", "Você concluiu seu primeiro curso!");

INSERT INTO achievement (name, description)
VALUES ("MONSTRO SAGRADO!", "Você concluiu TODOS os cursos!");

-- popula tabela course

INSERT INTO course (id_user_author, name, duration, difficulty, description, icon)
VALUES (1, "Harmonia", "20h", "difícil", "Harmonia funcional e tudo mais.", "ícone");

INSERT INTO course (id_user_author, name, duration, difficulty, description, icon)
VALUES (1, "Escalas", "12h", "fácil", "Escalas maiores e menores.", "ícone");

INSERT INTO course (id_user_author, name, duration, difficulty, description, icon)
VALUES (1, "Ritmo", "12h", "médio", "Como ler e criar ritmos.", "ícone");

INSERT INTO course (id_user_author, name, duration, difficulty, description, icon)
VALUES (2, "Leitura de partitura", "20h", "médio", "Encontrar notas e enteder ritmo", "ícone");

-- popula tabela class

INSERT INTO class
VALUES(1, "Funções harmônicas", "média", 1, 1);

INSERT INTO class
VALUES(2, "Função tônica", "fácil", 2, 1);

INSERT INTO class
VALUES(3, "Função subdominante", "fácil", 3, 1);

INSERT INTO class
VALUES(4, "Função dominante", "fácil", 4, 1);

INSERT INTO class
VALUES(5, "Escala maior", "fácil", 1, 2);

INSERT INTO class
VALUES(6, "Escala menor", "fácil", 2, 2);

INSERT INTO class
VALUES(7, "Semínima", "fácil", 1, 3);

INSERT INTO class
VALUES(8, "Clave de sol", "fácil", 1, 4);

INSERT INTO class
VALUES(9, "Clave de fá", "fácil", 2, 4);

-- popula a tabela paragraph

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Existem 3 principais funções. Falaremos delas nas proximas aulas", "image", 1, 1);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Transmite a sensação de repouso e finalização", "image", 2, 1);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Transmite também a sensação de estabilidade", "image", 2, 1);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Transmite a sensação de caminhar", "image", 3, 1);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Transmite a sensação de tensão", "image", 4, 1);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("É dada pelos intervalos: T T St T T T St", "image", 5, 2);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Possui características alegres", "image", 5, 2);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Seu 6 grau é sua relativa menor", "image", 5, 2);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("É dada pelos intervalos: T St T T St T T", "image", 6, 2);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Possui características tristes", "image", 6, 2);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("É 1/4 do tempo de um compasso 4/4. Tem a seguinte figura", "image", 7, 3);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Indica que o Sol está na 2 linha. Tem a seguinte forma", "image", 8, 4);

INSERT INTO paragraph (content, image, Class_id_class, Class_Course_id_course)
VALUES ("Indica que o Fá está na 4 linha. Tem a seguinte forma", "image", 9, 4);

-- popula tabela question

INSERT INTO question
VALUES (1, "Questão 1", "image", "Qual das seguintes escalas é maior?", 5, 2, 1);

INSERT INTO question
VALUES (2, "Questão 2", "image", "Qual das seguintes representa um Sol maior?", 5, 2, 2);

INSERT INTO question
VALUES (3, "Questão 1", "image", "Qual das seguintes escalas é menor?", 6, 2, 1);

INSERT INTO question
VALUES (4, "Questão 1", "image", "Qual destas notas é um Sol?", 8, 4, 1);

INSERT INTO question
VALUES (5, "Questão 2", "image", "Qual destas notas é um Dó?", 8, 4, 2);

INSERT INTO question
VALUES (6, "Questão 1", "image", "Qual destas notas é um Sol?", 9, 4, 1);

INSERT INTO question
VALUES (7, "Questão 2", "image", "Qual destas notas é um Dó?", 9, 4, 2);

-- popula tabela alternative

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 1);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 2);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 3);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 4);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 5);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 6);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("certa", 1, 7);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 7);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 7);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 7);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 7);

INSERT INTO alternative (text, correct, Question_id_question)
VALUES ("errada", 0, 7);

-- popula tabela user

INSERT INTO user (name, role, logo, bio)
VALUES ("Professor Risco", "professor", "logo", "Professor especializado em jazz. Tocou por 14 anos em banda mundo afora");

INSERT INTO user (name, role, logo, bio)
VALUES ("Jorge Aluno", "aluno", "logo", "Comecei a tocar guitarra em 2015 e quero aprender novos estilos");

-- popula tabela user_has_achievement

INSERT INTO user_has_achievement (User_id_user, achievement_id_achievement)
VALUES (1, 1);

INSERT INTO user_has_achievement (User_id_user, achievement_id_achievement)
VALUES (1, 2);

INSERT INTO user_has_achievement (User_id_user, achievement_id_achievement)
VALUES (1, 3);

INSERT INTO user_has_achievement (User_id_user, achievement_id_achievement)
VALUES (2, 5);

-- popula tabela user_has_course

INSERT INTO user_has_course (User_id_user, Course_id_course)
VALUES (1, 1);

INSERT INTO user_has_course (User_id_user, Course_id_course)
VALUES (1, 2);

INSERT INTO user_has_course (User_id_user, Course_id_course)
VALUES (1, 3);

INSERT INTO user_has_course (User_id_user, Course_id_course)
VALUES (1, 4);

-- popula user_has_class

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 1, 1, 1, 100);

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 2, 1, 0, 70);

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 5, 2, 1, 100);

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 6, 2, 0, 10);

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 8, 4, 1, 100);

INSERT INTO user_has_class (User_id_user, Class_id_class, Class_Course_id_course, completed, progress)
VALUES (2, 9, 4, 0, 0);