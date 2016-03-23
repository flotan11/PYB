--
-- PostgreSQL database cluster dump
--

-- Started on 2016-03-23 16:40:52

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

CREATE DATABASE "Etudiants" WITH TEMPLATE = template0 OWNER = mardonf;
REVOKE ALL ON DATABASE template1 FROM PUBLIC;
REVOKE ALL ON DATABASE template1 FROM postgres;
GRANT ALL ON DATABASE template1 TO postgres;
GRANT CONNECT ON DATABASE template1 TO PUBLIC;


\connect "Etudiants"

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta1
-- Dumped by pg_dump version 9.5beta1

-- Started on 2016-03-23 16:40:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16535)
-- Name: controlbdd; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA controlbdd;


ALTER SCHEMA controlbdd OWNER TO postgres;

--
-- TOC entry 7 (class 2615 OID 16427)
-- Name: supermarché; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "supermarché";


ALTER SCHEMA "supermarché" OWNER TO postgres;

--
-- TOC entry 196 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 196
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = controlbdd, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 195 (class 1259 OID 16539)
-- Name: produit; Type: TABLE; Schema: controlbdd; Owner: postgres
--

CREATE TABLE produit (
    num integer,
    libelle character varying(3),
    prix integer
);


ALTER TABLE produit OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 183 (class 1259 OID 16397)
-- Name: Etudiants; Type: TABLE; Schema: public; Owner: mardonf
--

CREATE TABLE "Etudiants" (
    "etudiantID" integer NOT NULL,
    "Nom" character varying(10),
    "Prenom" character varying(10)
);


ALTER TABLE "Etudiants" OWNER TO mardonf;

--
-- TOC entry 182 (class 1259 OID 16395)
-- Name: Etudiants_etudiantID_seq; Type: SEQUENCE; Schema: public; Owner: mardonf
--

CREATE SEQUENCE "Etudiants_etudiantID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Etudiants_etudiantID_seq" OWNER TO mardonf;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 182
-- Name: Etudiants_etudiantID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mardonf
--

ALTER SEQUENCE "Etudiants_etudiantID_seq" OWNED BY "Etudiants"."etudiantID";


--
-- TOC entry 187 (class 1259 OID 16422)
-- Name: absence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE absence (
    idabs integer NOT NULL,
    date character varying(10)
);


ALTER TABLE absence OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16409)
-- Name: clients; Type: TABLE; Schema: public; Owner: mardonf
--

CREATE TABLE clients (
    nom character varying(10),
    prenom character varying(10),
    age integer
);


ALTER TABLE clients OWNER TO mardonf;

--
-- TOC entry 186 (class 1259 OID 16417)
-- Name: justificatif; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE justificatif (
    libelle character varying(3),
    id integer NOT NULL,
    datedeb character varying(10),
    datefin character varying(10)
);


ALTER TABLE justificatif OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16412)
-- Name: personne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE personne (
    login character varying(10) NOT NULL,
    mdp character varying(10),
    role character varying(10),
    age integer
);


ALTER TABLE personne OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 16536)
-- Name: produit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE produit (
    num integer,
    libelle character varying(3),
    prix integer
);


ALTER TABLE produit OWNER TO postgres;

SET search_path = "supermarché", pg_catalog;

--
-- TOC entry 191 (class 1259 OID 16438)
-- Name: achat; Type: TABLE; Schema: supermarché; Owner: postgres
--

CREATE TABLE achat (
    nticket integer NOT NULL,
    ncaisse integer,
    date date
);


ALTER TABLE achat OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16436)
-- Name: achat_nticket_seq; Type: SEQUENCE; Schema: supermarché; Owner: postgres
--

CREATE SEQUENCE achat_nticket_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE achat_nticket_seq OWNER TO postgres;

--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 190
-- Name: achat_nticket_seq; Type: SEQUENCE OWNED BY; Schema: supermarché; Owner: postgres
--

ALTER SEQUENCE achat_nticket_seq OWNED BY achat.nticket;


--
-- TOC entry 192 (class 1259 OID 16519)
-- Name: ligneticket; Type: TABLE; Schema: supermarché; Owner: postgres
--

CREATE TABLE ligneticket (
    nticket integer,
    id integer,
    qute integer
);


ALTER TABLE ligneticket OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16430)
-- Name: produit; Type: TABLE; Schema: supermarché; Owner: postgres
--

CREATE TABLE produit (
    id integer NOT NULL,
    famille character varying(20),
    marque character varying(20),
    type character varying(20),
    format character varying(20),
    prix integer
);


ALTER TABLE produit OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16428)
-- Name: produit_id_seq; Type: SEQUENCE; Schema: supermarché; Owner: postgres
--

CREATE SEQUENCE produit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produit_id_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 188
-- Name: produit_id_seq; Type: SEQUENCE OWNED BY; Schema: supermarché; Owner: postgres
--

ALTER SEQUENCE produit_id_seq OWNED BY produit.id;


--
-- TOC entry 193 (class 1259 OID 16532)
-- Name: soldes; Type: TABLE; Schema: supermarché; Owner: postgres
--

CREATE TABLE soldes (
    id integer,
    marque character varying(20),
    type character varying(20),
    prix integer
);


ALTER TABLE soldes OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 2028 (class 2604 OID 16400)
-- Name: etudiantID; Type: DEFAULT; Schema: public; Owner: mardonf
--

ALTER TABLE ONLY "Etudiants" ALTER COLUMN "etudiantID" SET DEFAULT nextval('"Etudiants_etudiantID_seq"'::regclass);


SET search_path = "supermarché", pg_catalog;

--
-- TOC entry 2030 (class 2604 OID 16441)
-- Name: nticket; Type: DEFAULT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY achat ALTER COLUMN nticket SET DEFAULT nextval('achat_nticket_seq'::regclass);


--
-- TOC entry 2029 (class 2604 OID 16433)
-- Name: id; Type: DEFAULT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY produit ALTER COLUMN id SET DEFAULT nextval('produit_id_seq'::regclass);


SET search_path = controlbdd, pg_catalog;

--
-- TOC entry 2172 (class 0 OID 16539)
-- Dependencies: 195
-- Data for Name: produit; Type: TABLE DATA; Schema: controlbdd; Owner: postgres
--

COPY produit (num, libelle, prix) FROM stdin;
1	eau	1
2	VOD	13
3	SAU	3
4	PAT	4
\.


SET search_path = public, pg_catalog;

--
-- TOC entry 2160 (class 0 OID 16397)
-- Dependencies: 183
-- Data for Name: Etudiants; Type: TABLE DATA; Schema: public; Owner: mardonf
--

COPY "Etudiants" ("etudiantID", "Nom", "Prenom") FROM stdin;
1	Mardon	Florian
2	Pamaco	Nicola
\.


--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 182
-- Name: Etudiants_etudiantID_seq; Type: SEQUENCE SET; Schema: public; Owner: mardonf
--

SELECT pg_catalog.setval('"Etudiants_etudiantID_seq"', 1, false);


--
-- TOC entry 2164 (class 0 OID 16422)
-- Dependencies: 187
-- Data for Name: absence; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY absence (idabs, date) FROM stdin;
\.


--
-- TOC entry 2161 (class 0 OID 16409)
-- Dependencies: 184
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: mardonf
--

COPY clients (nom, prenom, age) FROM stdin;
Durand1	Paul1	1
Durand2	Paul2	2
Durand3	Paul3	3
Durand4	Paul4	4
Durand5	Paul5	5
Durand6	Paul6	6
Durand7	Paul7	7
Durand8	Paul8	8
Durand9	Paul9	9
Durand10	Paul10	10
Durand11	Paul11	11
Durand12	Paul12	12
Durand13	Paul13	13
Durand14	Paul14	14
Durand15	Paul15	15
Durand16	Paul16	16
Durand17	Paul17	17
Durand18	Paul18	18
Durand19	Paul19	19
Durand20	Paul20	20
Durand21	Paul21	21
Durand22	Paul22	22
Durand23	Paul23	23
Durand24	Paul24	24
Durand25	Paul25	25
Durand26	Paul26	26
Durand27	Paul27	27
Durand28	Paul28	28
Durand29	Paul29	29
Durand30	Paul30	30
Durand31	Paul31	31
Durand32	Paul32	32
Durand33	Paul33	33
Durand34	Paul34	34
Durand35	Paul35	35
Durand36	Paul36	36
Durand37	Paul37	37
Durand38	Paul38	38
Durand39	Paul39	39
Durand40	Paul40	40
Durand41	Paul41	41
Durand42	Paul42	42
Durand43	Paul43	43
Durand44	Paul44	44
Durand45	Paul45	45
Durand46	Paul46	46
Durand47	Paul47	47
Durand48	Paul48	48
Durand49	Paul49	49
Durand50	Paul50	50
\.


--
-- TOC entry 2163 (class 0 OID 16417)
-- Dependencies: 186
-- Data for Name: justificatif; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY justificatif (libelle, id, datedeb, datefin) FROM stdin;
\.


--
-- TOC entry 2162 (class 0 OID 16412)
-- Dependencies: 185
-- Data for Name: personne; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personne (login, mdp, role, age) FROM stdin;
lefebvrew	toto	etudiant	19
bourgep	toto	etudiant	19
everaec	toto	professeur	30
pamacon	toto	etudiant	19
mardonf	toto	etudiant	20
boinc	toto	Etudiant	19
guervid	toto	Etudiant	19
beaussn	toto	Etudiant	23
alpagaz	toto	Etudiant	50
\.


--
-- TOC entry 2171 (class 0 OID 16536)
-- Dependencies: 194
-- Data for Name: produit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produit (num, libelle, prix) FROM stdin;
\.


SET search_path = "supermarché", pg_catalog;

--
-- TOC entry 2168 (class 0 OID 16438)
-- Dependencies: 191
-- Data for Name: achat; Type: TABLE DATA; Schema: supermarché; Owner: postgres
--

COPY achat (nticket, ncaisse, date) FROM stdin;
1	1	2015-11-15
2	1	2015-10-15
3	3	2015-09-30
4	2	2015-03-15
5	7	2014-11-14
6	1	2015-12-15
7	2	2015-11-15
\.


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 190
-- Name: achat_nticket_seq; Type: SEQUENCE SET; Schema: supermarché; Owner: postgres
--

SELECT pg_catalog.setval('achat_nticket_seq', 7, true);


--
-- TOC entry 2169 (class 0 OID 16519)
-- Dependencies: 192
-- Data for Name: ligneticket; Type: TABLE DATA; Schema: supermarché; Owner: postgres
--

COPY ligneticket (nticket, id, qute) FROM stdin;
3	8	1
5	3	2
3	8	1
1	4	7
3	4	2
3	3	1
7	1	3
4	3	140
7	3	130
\.


--
-- TOC entry 2166 (class 0 OID 16430)
-- Dependencies: 189
-- Data for Name: produit; Type: TABLE DATA; Schema: supermarché; Owner: postgres
--

COPY produit (id, famille, marque, type, format, prix) FROM stdin;
1	eau	vitel	eau plate	pack 6*1.5L	6
3	piles	Duracel	Energizer AA	pack de 12	6
4	Coton-tiges	Carrefour	asymétrique	boite 500	4
5	Saucisses	Herta	Knacky	pack de 20	3
6	Alcool	Dworakoff	vodka	1L	12
8	Multimedia	Thomson	Television	unitaire	600
9	Multimedia	Samsung	Television	unitaire	650
10	piles	Duracel	OMG	7*7	100
\.


--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 188
-- Name: produit_id_seq; Type: SEQUENCE SET; Schema: supermarché; Owner: postgres
--

SELECT pg_catalog.setval('produit_id_seq', 10, true);


--
-- TOC entry 2170 (class 0 OID 16532)
-- Dependencies: 193
-- Data for Name: soldes; Type: TABLE DATA; Schema: supermarché; Owner: postgres
--

COPY soldes (id, marque, type, prix) FROM stdin;
2	panzani	spaguetti	3
5	Herta	Knacky	3
6	Dworakoff	vodka	12
7	Paul Walker	Whisky	13
9	Samsung	Television	650
\.


SET search_path = public, pg_catalog;

--
-- TOC entry 2032 (class 2606 OID 16405)
-- Name: Etudiant; Type: CONSTRAINT; Schema: public; Owner: mardonf
--

ALTER TABLE ONLY "Etudiants"
    ADD CONSTRAINT "Etudiant" PRIMARY KEY ("etudiantID");


--
-- TOC entry 2038 (class 2606 OID 16426)
-- Name: absence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY absence
    ADD CONSTRAINT absence_pkey PRIMARY KEY (idabs);


--
-- TOC entry 2036 (class 2606 OID 16421)
-- Name: justificatif_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY justificatif
    ADD CONSTRAINT justificatif_pkey PRIMARY KEY (id);


--
-- TOC entry 2034 (class 2606 OID 16416)
-- Name: personne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (login);


SET search_path = "supermarché", pg_catalog;

--
-- TOC entry 2042 (class 2606 OID 16443)
-- Name: achat_pkey; Type: CONSTRAINT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY achat
    ADD CONSTRAINT achat_pkey PRIMARY KEY (nticket);


--
-- TOC entry 2040 (class 2606 OID 16435)
-- Name: produit_pkey; Type: CONSTRAINT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY produit
    ADD CONSTRAINT produit_pkey PRIMARY KEY (id);


--
-- TOC entry 2044 (class 2606 OID 16527)
-- Name: ligneticket_id_fkey; Type: FK CONSTRAINT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY ligneticket
    ADD CONSTRAINT ligneticket_id_fkey FOREIGN KEY (id) REFERENCES produit(id);


--
-- TOC entry 2043 (class 2606 OID 16522)
-- Name: ligneticket_nticket_fkey; Type: FK CONSTRAINT; Schema: supermarché; Owner: postgres
--

ALTER TABLE ONLY ligneticket
    ADD CONSTRAINT ligneticket_nticket_fkey FOREIGN KEY (nticket) REFERENCES achat(nticket);


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-23 16:40:54

--
-- PostgreSQL database dump complete
--

\connect postgres

SET default_transaction_read_only = off;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta1
-- Dumped by pg_dump version 9.5beta1

-- Started on 2016-03-23 16:40:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2138 (class 1262 OID 12373)
-- Dependencies: 2137
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 7 (class 2615 OID 16542)
-- Name: pyb; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA pyb;


ALTER SCHEMA pyb OWNER TO postgres;

--
-- TOC entry 189 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 189
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 188 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 188
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16580)
-- Name: infouser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE infouser (
    iduser integer,
    solde numeric,
    parieperdu integer,
    pariegagner integer
);


ALTER TABLE infouser OWNER TO postgres;

SET search_path = pyb, pg_catalog;

--
-- TOC entry 184 (class 1259 OID 16556)
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
-- TOC entry 186 (class 1259 OID 16586)
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
-- TOC entry 182 (class 1259 OID 16545)
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
-- TOC entry 181 (class 1259 OID 16543)
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
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 181
-- Name: client_idc_seq; Type: SEQUENCE OWNED BY; Schema: pyb; Owner: postgres
--

ALTER SEQUENCE client_idc_seq OWNED BY "User".idc;


--
-- TOC entry 187 (class 1259 OID 16592)
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
-- TOC entry 183 (class 1259 OID 16554)
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
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 183
-- Name: paris_idp_seq; Type: SEQUENCE OWNED BY; Schema: pyb; Owner: postgres
--

ALTER SEQUENCE paris_idp_seq OWNED BY "Evenement".idp;


--
-- TOC entry 2006 (class 2604 OID 16559)
-- Name: idp; Type: DEFAULT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement" ALTER COLUMN idp SET DEFAULT nextval('paris_idp_seq'::regclass);


--
-- TOC entry 2005 (class 2604 OID 16548)
-- Name: idc; Type: DEFAULT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "User" ALTER COLUMN idc SET DEFAULT nextval('client_idc_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- TOC entry 2130 (class 0 OID 16580)
-- Dependencies: 185
-- Data for Name: infouser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY infouser (iduser, solde, parieperdu, pariegagner) FROM stdin;
\.


SET search_path = pyb, pg_catalog;

--
-- TOC entry 2129 (class 0 OID 16556)
-- Dependencies: 184
-- Data for Name: Evenement; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "Evenement" (idp, nom, createur, type, description, participants) FROM stdin;
\.


--
-- TOC entry 2131 (class 0 OID 16586)
-- Dependencies: 186
-- Data for Name: InfoUser; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "InfoUser" (iduser, solde, parisperdu, parisgagner) FROM stdin;
\.


--
-- TOC entry 2127 (class 0 OID 16545)
-- Dependencies: 182
-- Data for Name: User; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY "User" (idc, prenom, nom, age, adresse, ville, cpostal, pseudo, mdp) FROM stdin;
\.


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 181
-- Name: client_idc_seq; Type: SEQUENCE SET; Schema: pyb; Owner: postgres
--

SELECT pg_catalog.setval('client_idc_seq', 1, false);


--
-- TOC entry 2132 (class 0 OID 16592)
-- Dependencies: 187
-- Data for Name: paris; Type: TABLE DATA; Schema: pyb; Owner: postgres
--

COPY paris (iduser, idevenement, valeur, datef) FROM stdin;
\.


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 183
-- Name: paris_idp_seq; Type: SEQUENCE SET; Schema: pyb; Owner: postgres
--

SELECT pg_catalog.setval('paris_idp_seq', 1, false);


--
-- TOC entry 2008 (class 2606 OID 16553)
-- Name: client_pkey; Type: CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "User"
    ADD CONSTRAINT client_pkey PRIMARY KEY (idc);


--
-- TOC entry 2010 (class 2606 OID 16566)
-- Name: paris_idp_pkey; Type: CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement"
    ADD CONSTRAINT paris_idp_pkey PRIMARY KEY (idp);


--
-- TOC entry 2011 (class 2606 OID 16560)
-- Name: paris_idc_fkey; Type: FK CONSTRAINT; Schema: pyb; Owner: postgres
--

ALTER TABLE ONLY "Evenement"
    ADD CONSTRAINT paris_idc_fkey FOREIGN KEY (createur) REFERENCES "User"(idc);


--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-23 16:40:55

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

-- Started on 2016-03-23 16:40:55

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


-- Completed on 2016-03-23 16:40:58

--
-- PostgreSQL database dump complete
--

-- Completed on 2016-03-23 16:40:58

--
-- PostgreSQL database cluster dump complete
--

