https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-%ED%83%9C%EA%B7%B8-%EA%B8%B0%EB%8A%A5-%EB%B0%8F-%EC%82%AC%EC%9A%A9%EB%B2%95-tag

https://webruden.tistory.com/635


# TAG 
git tag v1.0.0
git tag -a v1.0.0 -m "Spring Boot Ch01"
git tag -a v1.0.2 4eb6a829850e43e353c972d268583549e0248424

# TAG SHOW 
git tag -n
git show-ref --tags
git show-ref --tags --dereference

# TAG PUSH
git push origin v1.0.0
git push origin --tags

# TAG - old commit
git log --pretty=oneline

# TAG DELETE
git push origin -d v1.0.0

