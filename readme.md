# spring-boot开发



## 待解决问题：

<u>**日期：20200905**</u>

### 	1.jpa方式访问数据库时，

​			

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    List<T> findAll();

    List<T> findAll(Sort var1);
	// 现在还没有实现
    List<T> findAllById(Iterable<ID> var1);
}
```

### 	2.idea相关设置

​		**注释**

### 	3.mybatis实现数据库访问时，增删改查练习

