--
-- PostgreSQL database cluster dump
--

-- Started on 2016-03-24 08:21:10

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE mardonf;
ALTER ROLE mardonf WITH SUPERUSER NOINHERIT CREATEROLE CREATEDB LOGIN NOREPLICATION NOBYPASSRLS PASSWORD 'md569a84ab6928437408b5a7db15f2995bd' VALID UNTIL 'infinity';
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'md5b2568ac910d16e5cd75423a571c97397';






--
-- Database creation
--

REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta1
-- Dumped by pg_dump version 9.5beta1

-- Started on 2016-03-24 08:21:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2131 (class 1262 OID 12373)
-- Dependencies: 2130
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 6 (class 2615 OID 16542)
-- Name: pyb; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA pyb;


ALTER SCHEMA pyb OWNER TO postgres;

--
-- TOC entry 187 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 187
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 186 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 186
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = pyb, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 16556)
-- Name: Evenement; Type: TABLE; Schema: pyb; Owner: postgres
--

CREATE TABLE "Evenement" (
    idp integer NOT NULL,
    nom character varying(20) NOT NULL,
    createur integer NOT NULL,
    type character varying(10) NOT NULL,
    description character varying(250) NOT NULL,
    participants integer NOT NULL
);


ALTER TABLE "Evenement" OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16586)
-- Name: InfoUser; Type: TABLE; Schema: pyb; Owner: postgres
--

CREATE TABLE "InfoUser" (
    iduser integer,
    solde numeric,
    parisperdu integer,
    parisgagner integer
);


ALTER TABLE "InfoUser" OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16545)
-- Name: User; Type: TABLE; Schema: pyb; Owner: postgres
--

CREATE TABLE "User" (
    idc integer NOT NULL,
    prenom character varying(20) NOT NULL,
    nom character varying(20) NOT NULL,
    age integer NOT NULL,
    adresse character varying(40) NOT NULL,
    ville character varying(30) NOT NULL,
    cpostal integer NOT NULL,
    pseudo character varying(20) NOT NULL,
    mdp character varying(20) NOT NULL
);


ALTER TABLE "User" OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16543)
-- Name: client_idc_seq; Type: SEQUENCE; Schema: pyb; Owner: postgres
--

CREATE SEQUENCE client_idc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_idc_seq OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 180
-- Name: client_idc_seq; Type: SEQUENCE OWNED BY; Schema: pyb; Owner: postgres
--

ALTER SEQUENCE client_idc_seq OWNED BY "User".idc;


--
-- TOC entry 185 (class 1259 OID 16592)
-- Name: paris; Type: TABLE; Schema: pyb; Owner: postgres
--

CREATE TABLE paris (
    iduser integer,
    idevenement integer,
    valeur numeric,
    datef date
);


ALTER TABLE paris OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16554)
-- Name: paris_idp_seq; Type: SEQUENCE; Schema: pyb; Owner: postgres
--

CREATE SEQUENCE paris_idp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE paris_idp_seq OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 182
-- Name: paris_idp_seq; Type: SEQUENCE OWNED BY; Schema: pyb; Owner: postgres
--

ALTER SEQUENCE paris_idp_seq OWNED BY "Evenement".idp;


--
-- TOC entry 2000 (class 2604 OID 16559)
-- Name: idp; Type: DEFAULT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement" ALTER COLUMN idp SET DEFAULT nextval('paris_idp_seq'::regclass);


--
-- TOC entry 1999 (class 2604 OID 16548)
-- Name: idc; Type: DEFAULT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "User" ALTER COLUMN idc SET DEFAULT nextval('client_idc_seq'::regclass);


--
-- TOC entry 2123 (class 0 OID 16556)
-- Dependencies: 183
-- Data for Name: Evenement; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "Evenement" (idp, nom, createur, type, description, participants) FROM stdin;
\.


--
-- TOC entry 2124 (class 0 OID 16586)
-- Dependencies: 184
-- Data for Name: InfoUser; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "InfoUser" (iduser, solde, parisperdu, parisgagner) FROM stdin;
\.


--
-- TOC entry 2121 (class 0 OID 16545)
-- Dependencies: 181
-- Data for Name: User; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "User" (idc, prenom, nom, age, adresse, ville, cpostal, pseudo, mdp) FROM stdin;
\.


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 180
-- Name: client_idc_seq; Type: SEQUENCE SET; Schema: pyb; Owner: postgres
--

SELECT pg_catalog.setval('client_idc_seq', 1, false);


--
-- TOC entry 2125 (class 0 OID 16592)
-- Dependencies: 185
-- Data for Name: paris; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY paris (iduser, idevenement, valeur, datef) FROM stdin;
\.


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 182
-- Name: paris_idp_seq; Type: SEQUENCE SET; Schema: pyb; Owner: postgres
--

SELECT pg_catalog.setval('paris_idp_seq', 1, false);


--
-- TOC entry 2002 (class 2606 OID 16553)
-- Name: client_pkey; Type: CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "User"
    ADD CONSTRAINT client_pkey PRIMARY KEY (idc);


--
-- TOC entry 2004 (class 2606 OID 16566)
-- Name: paris_idp_pkey; Type: CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement"
    ADD CONSTRAINT paris_idp_pkey PRIMARY KEY (idp);


--
-- TOC entry 2005 (class 2606 OID 16560)
-- Name: paris_idc_fkey; Type: FK CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement"
    ADD CONSTRAINT paris_idc_fkey FOREIGN KEY (createur) REFERENCES "User"(idc);


-- Completed on 2016-03-24 08:21:11

--
-- PostgreSQL database dump complete
--

\connect template1

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta1
-- Dumped by pg_dump version 9.5beta1

-- Started on 2016-03-24 08:21:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2094 (class 1262 OID 1)
-- Dependencies: 2093
-- Name: template1; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE template1 IS 'default template for new databases';


--
-- TOC entry 180 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2097 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2096 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-24 08:21:13

--
-- PostgreSQL database dump complete
--

-- Completed on 2016-03-24 08:21:13

--
-- PostgreSQL database cluster dump complete
--

