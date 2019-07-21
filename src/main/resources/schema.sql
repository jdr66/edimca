CREATE TABLE public.support_requests (
    request_id integer NOT NULL,
    requester_id integer NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(500) NOT NULL,
    approver_id integer,
    priority smallint NOT NULL,
    approve_time date,
    tech_id integer,
    assign_time date,
    creation_time date
);

CREATE SEQUENCE public.support_requests_request_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;