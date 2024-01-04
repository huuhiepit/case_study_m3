# View employee
CREATE
    ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
    VIEW `db_manager_tour`.`view_employee_account` AS
SELECT
    `e`.`id` AS `id`,
    `e`.`name` AS `name`,
    `e`.`phone` AS `phone`,
    `e`.`address` AS `address`,
    `a`.`userName` AS `userName`,
    `a`.`urlImage` AS `urlImage`,
    `a`.`role` AS `role`
FROM
    (`db_manager_tour`.`employees` `e`
        JOIN `db_manager_tour`.`accounts` `a` ON ((`e`.`accounts_id` = `a`.`id`)))
WHERE
    (`a`.`role` LIKE 'EMPLOYEE')