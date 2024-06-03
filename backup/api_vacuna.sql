--
-- PostgreSQL database dump
--

-- Dumped from database version 11.8
-- Dumped by pg_dump version 11.8

-- Started on 2024-06-02 18:31:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 204 (class 1259 OID 49812)
-- Name: empleado_generatos; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empleado_generatos
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empleado_generatos OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 49737)
-- Name: empleados; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empleados (
    cedula_empl character varying,
    nombre_empl character varying,
    apellido_empl character varying,
    email_empl character varying,
    fechan_empl date,
    direccion_empl character varying,
    telefono_empl character varying,
    estadovacu_empl character varying(100),
    id integer NOT NULL
);


ALTER TABLE public.empleados OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 49765)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 49745)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    nombre character varying
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 49743)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.roles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 49760)
-- Name: usuario_autoridad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario_autoridad (
    usuarioe_id bigint NOT NULL,
    rolee_id bigint NOT NULL
);


ALTER TABLE public.usuario_autoridad OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 49754)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre_usua character varying,
    contrasenia_usua character varying,
    estado_usua integer
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 49752)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuarios ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 49799)
-- Name: vacunas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vacunas (
    id integer,
    id_empledo_vacu integer,
    numero_doci_vacu integer,
    fecha_vacu date,
    tipo_vacu character varying
);


ALTER TABLE public.vacunas OWNER TO postgres;

--
-- TOC entry 2837 (class 0 OID 49737)
-- Dependencies: 196
-- Data for Name: empleados; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empleados (cedula_empl, nombre_empl, apellido_empl, email_empl, fechan_empl, direccion_empl, telefono_empl, estadovacu_empl, id) FROM stdin;
0400755096	MANUEL JACOME	JACOME CABRERA	mejc1569@gmail.com	1978-09-11	TULCAN	09464646	Vacunado	79
1002036591	LIDIA IRENE	HERANDEZ BERNAL	lidiaIrene@gmail.com	1978-10-11	TULCAN	0946464632	Vacunado	81
0401096219	JEFFERSON ANDRES	JACOME CABRERA	jjandres12@gmail.com	1989-09-10	quito	0904096219	Vacunado	77
0401096218	GABRIELA CARDENAS	CARDENAS ROSERO	gcardenas@gmail.com	1990-06-14	IBARRA	0998614619	No Vacunado	84
0401058847	MARCELO EXANOVER	TORO QUISTANCHALA	correo@prueba1.com	2000-04-04	TULCAN	06224013	No Vacunado	85
0401096326	LIDIA IRENE	HERANDEZ BERNAL	lidiaIrene@gmail.com	1978-10-11	TULCAN	0946464632	Vacunado	88
\.


--
-- TOC entry 2839 (class 0 OID 49745)
-- Dependencies: 198
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, nombre) FROM stdin;
1	ROLE_USER
2	ROLE_ADMIN
\.


--
-- TOC entry 2842 (class 0 OID 49760)
-- Dependencies: 201
-- Data for Name: usuario_autoridad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_autoridad (usuarioe_id, rolee_id) FROM stdin;
1	2
2	1
1	1
\.


--
-- TOC entry 2841 (class 0 OID 49754)
-- Dependencies: 200
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, nombre_usua, contrasenia_usua, estado_usua) FROM stdin;
1	andres	$2a$10$.hhZo5jmxO49h6oj2uagmON1V8bgGwiIWbCCNGK1h9iVTssKAuhu6	1
2	javier	$2a$10$.hhZo5jmxO49h6oj2uagmON1V8bgGwiIWbCCNGK1h9iVTssKAuhu6	1
\.


--
-- TOC entry 2844 (class 0 OID 49799)
-- Dependencies: 203
-- Data for Name: vacunas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vacunas (id, id_empledo_vacu, numero_doci_vacu, fecha_vacu, tipo_vacu) FROM stdin;
78	77	1	2021-01-05	Astrazeneca
80	79	1	2021-02-05	Sinovac
82	81	1	2021-02-22	Pfizer
83	77	2	2021-06-05	Sinovac
89	88	1	2021-02-22	Pfizer
\.


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 204
-- Name: empleado_generatos; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empleado_generatos', 1, false);


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 202
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 93, true);


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 197
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 2, true);


--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 199
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 2, true);


--
-- TOC entry 2715 (class 2606 OID 49764)
-- Name: usuario_autoridad ukgbinip2a73wwow5q6sjjd0n7d; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario_autoridad
    ADD CONSTRAINT ukgbinip2a73wwow5q6sjjd0n7d UNIQUE (usuarioe_id, rolee_id);


--
-- TOC entry 2712 (class 2606 OID 49815)
-- Name: empleados uq_cedula_empl; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT uq_cedula_empl UNIQUE (cedula_empl);


--
-- TOC entry 2713 (class 1259 OID 49784)
-- Name: roles_id_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX roles_id_idx ON public.roles USING btree (id);


-- Completed on 2024-06-02 18:31:03

--
-- PostgreSQL database dump complete
--

