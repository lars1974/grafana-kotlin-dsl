import random
import time

# Function to get the Linux timestamp for an hour ago
def get_timestamp():
    return int(time.time()) - 3600

# Get the starting timestamp (an hour ago)
start_timestamp = get_timestamp()

count200 = 0
time200 = 0.0
count400 = 0
time400 = 0.0

with open('volumens/prometheus/sample-data.txt', 'wb') as f:
    for i in range(1, 360):
        timestamp = int(start_timestamp + (i * 10))

        f.write(f'http_server_requests_seconds_count{{status="200",method="post",uri="api/endpoint"}} {count200} {timestamp}\n'.encode('utf-8'))
        f.write(f'http_server_requests_seconds_sum{{status="200",method="post",uri="api/endpoint"}} {time200} {timestamp}\n'.encode('utf-8'))

        f.write(f'http_server_requests_seconds_count{{status="400",method="post",uri="api/endpoint"}} {count400} {timestamp}\n'.encode('utf-8'))
        f.write(f'http_server_requests_seconds_sum{{status="400",method="post",uri="api/endpoint"}} {time400} {timestamp}\n'.encode('utf-8'))

        count200 = count200 + random.randint(10, 100)
        time200 = time200 + count200 * random.randint(1, 10)

        count400 = count400 + random.randint(1, 10)
        time400 = time400 + count400 * random.randint(1, 10)

    f.write(f'# EOF'.encode('utf-8'))



