CREATE TABLE `tb_aut_autorizacao` (
  `aut_id` int(11) NOT NULL,
  `aut_id_autorizacao` varchar(45) NOT NULL,
  `aut_nome_servico` varchar(45) NOT NULL,
  `aut_dt_solicitacao` datetime NOT NULL,
  `aut_id_cliente` varchar(20) NOT NULL,
  `aut_ds_token` varchar(10) DEFAULT NULL,
  `aut_ds_mensagem_autorizacao` varchar(110) NOT NULL,
  `aut_st_autorizacao` varchar(45) GENERATED ALWAYS AS (0) VIRTUAL,
  PRIMARY KEY (`aut_id`),
  UNIQUE KEY `aut_id_autorizacao_UNIQUE` (`aut_id_autorizacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
