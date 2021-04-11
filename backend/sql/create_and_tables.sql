CREATE TABLE providers (
	id bigint not null,
	code varchar not null,
	logo_url varchar not null,
	name varchar not null,
	summary varchar not null,
	is_active boolean not null,
	PRIMARY KEY (id)
)

CREATE TABLE products (
	id bigint not null,
	vertical_id bigint not null,
	provider_id bigint not null,
	is_sponsored boolean not null,
	data json not null,
	PRIMARY KEY (id),
	FOREIGN KEY (provider_id) REFERENCES "providers"(id)
)

CREATE TABLE verticals (
	id bigint not null,
	code varchar not null,
	name varchar not null
)