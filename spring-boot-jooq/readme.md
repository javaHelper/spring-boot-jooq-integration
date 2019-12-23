
Request

```
http://localhost:8080/api/posts
```

Response
```
[
    {
        "id": 1,
        "title": "Post 1",
        "content": "This is post 1",
        "createdOn": "2020-01-02T18:30:00.000+0000",
        "comments": null
    },
    {
        "id": 2,
        "title": "Post 2",
        "content": "This is post 2",
        "createdOn": "2020-01-04T18:30:00.000+0000",
        "comments": null
    },
    {
        "id": 3,
        "title": "Post 3",
        "content": "This is post 3",
        "createdOn": "2020-01-06T18:30:00.000+0000",
        "comments": null
    }
]
```

Request
```
http://localhost:8080/api/post/1
```


Response
```
{
    "id": 1,
    "title": "Post 1",
    "content": "This is post 1",
    "createdOn": "2020-01-02T18:30:00.000+0000",
    "comments": [
        {
            "id": 1,
            "name": "User1",
            "email": "user1@gmail.com",
            "content": "This is comment 1 on post 1",
            "createdOn": "2020-01-06T18:30:00.000+0000"
        },
        {
            "id": 2,
            "name": "User2",
            "email": "user2@gmail.com",
            "content": "This is comment 2 on post 1",
            "createdOn": "2020-01-06T18:30:00.000+0000"
        }
    ]
}
```