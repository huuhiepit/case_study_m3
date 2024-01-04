CREATE
ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
VIEW `db_manager_tour`.`view_bookings` AS
SELECT
    `b`.`id` AS `id`,
    `b`.`seat` AS `seat`,
    `b`.`totalPrice` AS `totalPrice`,
    `b`.`dateBooking` AS `dateBooking`,
    `b`.`status` AS `status`,
    `b`.`payment` AS `payment`,
    `c`.`name` AS `customerName`,
    `c`.`phone` AS `phone`,
    `t`.`name` AS `tourName`,
    `dt`.`dateStart` AS `dateStart`,
    `dt`.`dateEnd` AS `dateEnd`,
    `e`.`name` AS `employeeName`
FROM
    ((((`db_manager_tour`.`bookings` `b`
        JOIN `db_manager_tour`.`customers` `c` ON ((`b`.`customers_id` = `c`.`id`)))
        JOIN `db_manager_tour`.`tours` `t` ON ((`b`.`tours_id` = `t`.`id`)))
        JOIN `db_manager_tour`.`employees` `e` ON ((`e`.`id` = `b`.`employees_id`)))
        JOIN `db_manager_tour`.`description_tours` `dt` ON ((`t`.`description_tours_id` = `dt`.`id`)))