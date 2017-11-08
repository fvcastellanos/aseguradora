ALTER TABLE `aseguradora`.`boleta`
ADD INDEX `idx_boleta_mes_anio` (`mes` ASC, `anio` ASC);

ALTER TABLE `aseguradora`.`poliza`
DROP COLUMN `tipo`;

ALTER TABLE `aseguradora`.`boleta`
ADD COLUMN `pagada` CHAR(1) NULL DEFAULT 'N' AFTER `fecha_pago`;

