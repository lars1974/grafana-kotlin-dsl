docker compose down
python ./python_scripts/prometheus_data_generator.py
docker compose up -d
docker compose exec prometheus sh ./load-sample-data.sh
