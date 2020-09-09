### idea常用注释：

参考链接：https://blog.csdn.net/u010608551/article/details/107557003

以下为@param 获取参数方法，其他的可自定义：

```js
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+=(i==0 ? '' : ' @param'+(i+1)+': ') + params[i] + ((i < params.size() - 1) ? '、':'')}; return result", methodParameters())
```

