#@layout()
#define main()
<h1>新闻管理&nbsp;&nbsp;
<a href="/news/add">创建新闻</a>
</h1>
<div class="table_box">
    <table class="list">
        <tbody>
            <tr>
                <th width="4%">id</th>
                <th width="4%">发布人名称</th>
                <th width="35%">标题</th>
                <th width="12%">操作</th>
            </tr>
            
            #for(x : newsPage.getList())
            <tr>
                <td style="text-align:left;">#(x.id)</td>
                <td style="text-align:left;">#(x.name)</a></td>
                <td style="text-align:left;">#(x.title)</td>
                <td style="text-align:left;">
                    &nbsp;&nbsp;<a href="/news/detail/#(x.id)">详情</a>
                    &nbsp;&nbsp;<a href="/news/delete/#(x.id)">删除</a>
                    &nbsp;&nbsp;<a href="/news/edit/#(x.id)">修改</a>
                </td>
            </tr>
            #end
        </tbody>
    </table>
    #@paginate0(newsPage.pageNumber, newsPage.totalPage, "/news/"+col)
</div>
<!-- <script>
console.log("window", window.location.href);
var a = window.location.href;
var t = a.split('news/')[1].split('?')[0];
</script> -->
#end
