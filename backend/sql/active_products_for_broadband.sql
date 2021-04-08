SELECT * FROM products prod
	INNER JOIN providers prov ON prod.provider_id = prov.id
	WHERE prov.is_active AND prod.data -> 'internet_download_speed_in_mbs' IS NOT NULL;