// replication configuration
// Docker container 생성 후 mongo CLI에서 아래 커맨드를 사용하여 replication을 설정한다
config = {
  "_id": "rs",
  "members": [
    {
      "_id": 0,
      "host": "localhost:27017"
    }
  ]
};

rs.initiate(config);
