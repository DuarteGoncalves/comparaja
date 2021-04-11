SELECT * FROM products prod
	INNER JOIN providers prov ON prod.provider_id = prov.id
	INNER JOIN verticals vert ON prod.vertical_id = vert.id
	WHERE prov.is_active AND vert.code = 'BB';