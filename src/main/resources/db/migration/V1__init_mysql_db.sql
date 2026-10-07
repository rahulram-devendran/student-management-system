drop table if exists courses;

drop table if exists student;

CREATE TABLE `courses`
(
    `id`      binary(16) NOT NULL,
    `author`  varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `name`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `version` int        NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE `student`
(
    `id`            binary(100)                             NOT NULL,
    `department`    varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `mobile_number` varchar(10) COLLATE utf8mb4_unicode_ci  DEFAULT NULL,
    `name`          varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `version`       int                                     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
