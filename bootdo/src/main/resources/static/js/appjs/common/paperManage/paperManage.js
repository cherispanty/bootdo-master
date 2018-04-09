
var prefix = "/common/paperManage"
$(function() {
	
	//	var config = {
	//		'.chosen-select' : {},
	//		'.chosen-select-deselect' : {
	//			allow_single_deselect : true
	//		},
	//		'.chosen-select-no-single' : {
	//			disable_search_threshold : 10
	//		},
	//		'.chosen-select-no-results' : {
	//			no_results_text : '没有数据'
	//		},
	//		'.chosen-select-width' : {
	//			width : "95%"
	//		}
	//	}
	//	for (var selector in config) {
	//		$(selector).chosen(config[selector]);
	//	}
	load();
});

function selectLoad() {
	var html = "";
    $.ajax({
        url : '/common/selectStudent/dept',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].deptId + '">' + data[i].name + '</option>';
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
            // 点击事件
            // $('.chosen-select').on('change', function(e, params) {
            // 	console.log(params.selected);
            // 	var opt = {
            // 		query : {
            // 			type : params.selected,
            // 		}
            // 	}
            // 	$('#exampleTable').bootstrapTable('refresh', opt);
            // });
        }
    });
}
function load() {
	selectLoad();
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载地址
				//	showRefresh : true,
				//	showToggle : true,
				//	showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : false, // 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				//search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
                        name: $('#name').val(),
						studentId: $('#studentId').val(),
						teacherId: $('#teacherId').val(),
                        createTime: $('#createTime').val(),
                        deptId: $('.chosen-select').val()
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
                    {
                        title: '序号',//标题  可不加
                        formatter: function (value, row, index) {
                            return index + 1;
                        },
						align: "center"
                    },
                    {
                    	visible: false,
                        field : 'paperTitle',
                        title : '论文题目',
                        align: "center"
                    },
                    {
                        field : 'name',
                        title : '论文名称',
                        align: "center"
                    },
					{
						field : 'studentName',
						title : '学生',
                        align: "center"
					},
                    {
                        field : 'className',
                        title : '班级',
                        align: "center"
                    },
                    {
                        field : 'teacherName',
                        title : '指导老师',
                        align: "center"
                    },
					{
						field : 'createTime',
						title : '上传时间',
                        align: "center"
					},
                    {
                        field : 'status',
                        title : '论文状态',
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (value == '0') {
                                return '<span class="label label-warning">待审核</span>';
                            } else if (value == '1') {
                                return '<span class="label label-primary">通过</span>';
                            }else if (value == '-1') {
                                return '<span class="label label-danger">驳回</span>';
                            }else if (value == '-2') {
                                return '<span class="label label-danger">已撤销</span>';
                            }
                        }
                    },
					{
						visible: false,
						field : 'collection',
						title : '收录情况',
                        align: "center"
					},
					{
                        visible: false,
                        field : 'influence',
                        title : '影响力',
                        align: "center"
                    },
					{
                        visible: false,
                        field : 'factor',
                        title : '影响因子',
                        align: "center"
                    },
					{
                        visible: true,
                        field : 'score',
                        title : '答辩分数',
                        align: "center"
                    },
                    {
                        visible: false,
                        field : 'reviewOpinion',
                        title : '评审意见',
                        align: "center"
                    },
					{
						title : '操作',
						field : 'userId',
						align : 'center',
						formatter : function(value, row, index) {
							console.log("row : "+JSON.stringify(JSON.stringify(row)));
                            var e = '<a  class="btn btn-primary btn-sm" href="' + row.url + '" download="' + row.name + '"></i>下载</a>';
                            var f = '<button  class="btn btn-primary btn-sm" onclick="detail(\''
                                + row.id
                                + '\')"></i>录入详情</button> ';
                            var g = '<button  class="btn btn-danger btn-sm" onclick="cancel(\''
                                + row.id
                                + '\')"></i>撤销</button> ';
                            var h = '<button  class="btn btn-danger btn-sm" onclick="remove(\''
                                + row.id
                                + '\')"></i>删除</button> ';
                            return e+' '+f;
						}
					} ]
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function detail(id) {
	console.log("id:"+id);
    layer.open({
        type : 2,
        title : '录入论文详细',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/detail/' + id // iframe的url
    });
}

function cancel(id) {
    layer.confirm('撤销后老师将看不到论文，确定撤销？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix + "/cancel",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                }else {
                    layer.msg(r.msg);
                }
            }
        });
    })

}

function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}


//1 判断当前学生是否已有了导师，如果有了就不能申请
//2 判断该老师是否邀请了自己，并且状态为未查看，如果邀请了并且为“未查看”状态就不可以再去申请
function check(userId) {
    $.ajax({
        url : prefix + "/check",
        type : "post",
        data : {
            'userId' : userId
        },
        success : function(r) {
            if (r.code != 0) {
                //不允许申请
                layer.msg(r.msg);
                // reLoad();
                return;
            }else {
            	apply(userId);
			}
        }
    });
}

function apply(userId) {
	layer.open({
		type : 2,
		title : '申请导师',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/apply/' + userId // iframe的url
	});
}
function remove(id) {
	layer.confirm('文件删除后不可恢复，确定删除？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}

function addD(type,description) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/'+type+'/'+description // iframe的url
	});
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {});
}