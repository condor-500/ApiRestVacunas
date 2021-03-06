PGDMP     1    3                z         
   vacunacion    11.8    11.8                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            !           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            "           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            #           1262    49154 
   vacunacion    DATABASE     ?   CREATE DATABASE vacunacion WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.utf8' LC_CTYPE = 'Spanish_Spain.utf8';
    DROP DATABASE vacunacion;
             postgres    false            ?            1259    49812    empleado_generatos    SEQUENCE     {   CREATE SEQUENCE public.empleado_generatos
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.empleado_generatos;
       public       postgres    false            ?            1259    49737 	   empleados    TABLE     U  CREATE TABLE public.empleados (
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
    DROP TABLE public.empleados;
       public         postgres    false            ?            1259    49765    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false            ?            1259    49745    roles    TABLE     U   CREATE TABLE public.roles (
    id integer NOT NULL,
    nombre character varying
);
    DROP TABLE public.roles;
       public         postgres    false            ?            1259    49743    role_id_seq    SEQUENCE     ?   ALTER TABLE public.roles ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    198            ?            1259    49760    usuario_autoridad    TABLE     i   CREATE TABLE public.usuario_autoridad (
    usuarioe_id bigint NOT NULL,
    rolee_id bigint NOT NULL
);
 %   DROP TABLE public.usuario_autoridad;
       public         postgres    false            ?            1259    49754    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre_usua character varying,
    contrasenia_usua character varying,
    estado_usua integer
);
    DROP TABLE public.usuarios;
       public         postgres    false            ?            1259    49752    usuarios_id_seq    SEQUENCE     ?   ALTER TABLE public.usuarios ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    200            ?            1259    49799    vacunas    TABLE     ?   CREATE TABLE public.vacunas (
    id integer,
    id_empledo_vacu integer,
    numero_doci_vacu integer,
    fecha_vacu date,
    tipo_vacu character varying
);
    DROP TABLE public.vacunas;
       public         postgres    false                      0    49737 	   empleados 
   TABLE DATA               ?   COPY public.empleados (cedula_empl, nombre_empl, apellido_empl, email_empl, fechan_empl, direccion_empl, telefono_empl, estadovacu_empl, id) FROM stdin;
    public       postgres    false    196   ?                 0    49745    roles 
   TABLE DATA               +   COPY public.roles (id, nombre) FROM stdin;
    public       postgres    false    198   ?                 0    49760    usuario_autoridad 
   TABLE DATA               B   COPY public.usuario_autoridad (usuarioe_id, rolee_id) FROM stdin;
    public       postgres    false    201   ?                 0    49754    usuarios 
   TABLE DATA               R   COPY public.usuarios (id, nombre_usua, contrasenia_usua, estado_usua) FROM stdin;
    public       postgres    false    200                    0    49799    vacunas 
   TABLE DATA               _   COPY public.vacunas (id, id_empledo_vacu, numero_doci_vacu, fecha_vacu, tipo_vacu) FROM stdin;
    public       postgres    false    203   t       $           0    0    empleado_generatos    SEQUENCE SET     A   SELECT pg_catalog.setval('public.empleado_generatos', 1, false);
            public       postgres    false    204            %           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 83, true);
            public       postgres    false    202            &           0    0    role_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.role_id_seq', 2, true);
            public       postgres    false    197            '           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 2, true);
            public       postgres    false    199            ?
           2606    49764 -   usuario_autoridad ukgbinip2a73wwow5q6sjjd0n7d 
   CONSTRAINT     y   ALTER TABLE ONLY public.usuario_autoridad
    ADD CONSTRAINT ukgbinip2a73wwow5q6sjjd0n7d UNIQUE (usuarioe_id, rolee_id);
 W   ALTER TABLE ONLY public.usuario_autoridad DROP CONSTRAINT ukgbinip2a73wwow5q6sjjd0n7d;
       public         postgres    false    201    201            ?
           2606    49815    empleados uq_cedula_empl 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT uq_cedula_empl UNIQUE (cedula_empl);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT uq_cedula_empl;
       public         postgres    false    196            ?
           1259    49784    roles_id_idx    INDEX     <   CREATE INDEX roles_id_idx ON public.roles USING btree (id);
     DROP INDEX public.roles_id_idx;
       public         postgres    false    198               ?   x?m??n?@E?ٯ? ????badi?Q??m![?VH??lB???[????$ANag?I*?5?~'p?]??g`h????_΃?.?z?8?g?3"8???X@?ӟ???o?o&?Xb??4a??\?F?N??&P?J??R?5\??????g???E????0F
1le?w?[?N?%}????~R?G??o?ǭ???' ??GL???J?oϜO?         !   x?3???q?v?2??]|=??b???? t??            x?3?4?2?4?2?=... %
         _   x?3?L?K)J-?T1JT14P??Ȉ?7?ʭ?7??0??2*ML???3?HJw/??Orv?s?6̰?).?v,?(5?4?2??J,?L-?Ԝ=... y?-P         W   x?3??47?4?4202?5 "SN?⒢ĪԼ??D.NsK??H:83/?,1????I?Ȉ3 -?*????d?T?YS? ?k?     