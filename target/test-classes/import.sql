# DROP TABLE banners;
# CREATE TABLE `banners` (
#   `id`                INT(11) NOT NULL,
#   `action`            VARCHAR(64)   DEFAULT NULL,
#   `image`             VARCHAR(2083) DEFAULT NULL,
#   `related_object_id` BIGINT(20)    DEFAULT NULL,
#   `status`            SMALLINT(6)   DEFAULT NULL,
#   `subtitle`          VARCHAR(255)  DEFAULT NULL,
#   `title`             VARCHAR(255)  DEFAULT NULL,
#   `type`              SMALLINT(6)   DEFAULT NULL,
#   PRIMARY KEY (`id`)
# )
#   ENGINE = InnoDB
#   DEFAULT CHARSET = latin1;
INSERT INTO dnguyenminh.banners (id, action, image, related_object_id, status, subtitle, title, type)
VALUES (1, 'no action', 'no image', 1, 1, 'test sub title', 'test title', 1);
COMMIT;