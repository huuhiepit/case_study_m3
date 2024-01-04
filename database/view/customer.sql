CREATE
ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
VIEW `db_manager_tour`.`view_customer` AS
SELECT
    `c`.`id` AS `id`,
    `c`.`name` AS `name`,
    `c`.`phone` AS `phone`,
    `c`.`address` AS `address`,
    `c`.`email` AS `email`,
    `a`.`userName` AS `userName`
FROM
    (`db_manager_tour`.`customers` `c`
        JOIN `db_manager_tour`.`accounts` `a` ON ((`c`.`accounts_id` = `a`.`id`)))