
## 淘宝信息 --- TaoBaoInfo

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
| `user_data` | 用户数据 | UserData | 否 | V6版 |
| `report_data` | 报告数据 | ReportData | 否 | V5版  |

### 1、用户数据 --- UserData

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`userinfo`|用户基础信息|UserInfo|否|
|`alipaywealth`|支付宝资产|AliPayWealth|否|
|`deliveraddress`|淘宝收货地址|DeliverAddress|否|
|`recentdeliveraddress`|订单的收货地址|RecentDeliverAddress|否|
|`tradedetails`|淘宝订单信息|TradeDetails|否|

#### 1.1、用户基础信息 --- UserInfo

|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`gender`|性别|int|是|0-保密;1-男;2-女|
|`birthday`|生日|date|是|例：1993-07- 29T00:00:00.000+08|
|`constellation`|星座|string|是||
|`address`|居住地|string|是||
|`hometown`|家乡|string|是||
|`nick`|淘宝昵称|string|是||
|`real_name`|真实姓名|string|是||
|`phone_number`|电话号码|string|是||
|`email`|绑定的邮箱|string|是||
|`vip_level`|vip等级|int|是|无等级(-1)和0~6级|
|`vip_count`|成长值|int|是|约等于购物金额|
|`weibo_account`|绑定的微博账号|string|是||
|`weibo_nick`|绑定的微博昵称|string|是||
|`pic`|淘宝头像图片|string|是||
|`alipay_account`|绑定的支付宝账号|string|是||
|`tmall_level`|天猫等级|string|是||
|`first_ordertime`|最早一笔订单交易时间|string|是|格式为yyyy-MM-dd HH:mm:ss|
|`taobao_userid`|用户在淘宝中的用户ID|string|是||
|`tao_score`|淘气值|string|是||
|`account_auth`|是否认证|boolean|是||
|`address_code`|居住地区域编码|string|是||
|`hometown_code`|家乡区域编码|string|是||
|`security_level`|安全等级|string|是||
|`authentication`|身份是否认证|boolean|是||
|`login_password`|是否设置登录密码|boolean|是||
|`pwd_protect`|是否设置密保问题|boolean|是||
|`phone_bind`|是否绑定手机号码|boolean|是||

#### 1.2、支付宝资产 --- AliPayWealth

|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`balance`|账户余额|long|是|单位分|
|`total_profit`|余额宝历史累计收益|long|是|单位分|
|`total_quotient`|余额宝金额|long|是|单位分|
|`huabei_creditamount`|花呗当前可用额度|long|是|单位分|
|`huabei_totalcreditamount`|花呗授信额度|long|是|单位分|

#### 1.3、淘宝收货地址 --- DeliverAddress

|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`default`|是否默认收货地址|boolean|是|true:默认收货地址，false:非默认收货地址|
|`name`|姓名|string|是||
|`province`|省份|string|是|根据address分析取得，不包 含’省’这个字，如:北京、山东|
|`city`|城市|string|是|根据address分析取得，不包 含’市’这个字，如:济南，杭州|
|`address`|地址|string|是|到街道一级|
|`full_address`|详细地址|string|是||
|`zip_code`|邮编|string|是||
|`phone_no`|电话号码|string|是|“15*******15”|

#### 1.3、订单的收货地址 --- RecentDeliverAddress

|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`trade_id`|订单id|string|是||
|`trade_createtime`|订单时间|date|是|“2016-06-13T14:01:42.000+08”|
|`actual_fee`|订单费用|long|是|单位分|
|`deliver_name`|收货地址中的姓名|string|是||
|`deliver_mobilephone`|收货地址中的手机号码|string|是||
|`deliver_fixedphone`|收货地址中的固定电话|string|是||
|`province`|省份|string|是|根据deliver_address分析取得，不包 含’省’这个字，如:北京、山东|
|`city`|城市|string|是|根据deliver_address分析取得，不包 含’市’这个字，如:济南，杭州|
|`deliver_address`|详细地址|string|是||
|`deliver_postcode`|邮编|string|是||
|`invoice_name`|发票抬头|string|是||

#### 1.3、淘宝订单信息 --- TradeDetails
  
|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`trade_id`|订单id|string|是||
|`trade_status`|交易状态|string|是|WAIT_BUYER_PAY:等待买家付款<br>WAIT_SELLER_SEND_GOODS:等待卖家发货<br>SELLER_CONSIGNED_PART:卖家部分发货<br>WAIT_BUYER_CONFIRM_GOODS:等待买家确认收货<br>TRADE_FINISHED:交易成功<br>TRADE_CLOSED:交易关闭<br>TRADE_CLOSED_BY_TAOBAO:交易被淘宝关闭<br>CREATE_CLOSED_OF_TAOBAO:交易关闭<br>TRADE_NO_CREATE_PAY:没有创建外部交易(支付宝交易)<br>PAY_PENDING:外卡支付付款确认中|
|`trade_text`|交易状态中文|string|是||
|`trade_createtime`|交易时间|datetime|是|“2016-06-15T13:08:31.000+08”|
|`actual_fee`|订单金额|long|是|单位分|
|`seller_id`|卖家id|long|是|单位分|
|`seller_nick`|卖家昵称|string|是||
|`seller_shopname`|店铺名称|string|是||
|`sub_orders`|商品信息|subOrders|是||

- subOrders
  
|参数|名称|类型|是否可空|备注|
|---|---|---|---|---|
|`mapping_id`|映射ID|string|否|淘宝账号在魔蝎科技中的映射ID|
|`trade_id`|订单id|string|是||
|`item_id`|商品id|string|是||
|`item_url`|商品链接|string|是||
|`item_pic`|商品图片|string|是||
|`item_name`|商品名称|string|是||
|`quantity`|商品数量|int|是||
|`original`|商品原价|long|是|单位分|
|`real_total`|商品真实交易价格|long|是|单位分|
|`cid_level1`|一级目录的id|string|是||
|`cid_level2`|二级目录的id|string|是||
|`cname_level1`|一级目录的名称|string|是||
|`cname_level2`|二级目录的名称|string|是||

- 示例

```

{
	"userinfo": {
		"gender": 1,
		"birthday": "1987-06-20T00:00:00.000+09",
		"constellation": "双子座",
		"address": "浙江省杭州市西湖区",
		"hometown": "河北省唐ft市古冶区",
		"authentication": true,
		"mapping_id": "8015209461024100000",
		"nick": "t_123456",
		"real_name": "张三",
		"phone_number": "136****0000",
		"email": "280****00@qq.com",
		"vip_level": 2,
		"vip_count": 27440,
		"weibo_account": "28***00@qq.com",
		"weibo_nick": "wb_123456",
		"pic": "//wwc.alicdn.com/avatar/getAvatar.do?userId=280788318&width=100",
		"alipay_account": "280****00@qq.com",
		"first_ordertime": "2009-11-09  21:26:36",
		"taobao_userid": "280780000",
		"tao_score": "619",
		"tmall_level": "T2",
		"tmall_vipcount": 540,
		"tmall_apass": "良好",
		"register_time": "2009-08-09T00:00:00.000+08",
		"account_auth": true,
		"address_code": "330106",
		"hometown_code": "130204",
		"security_level": "高",
		"login_password": true,
		"pwd_protect": true,
		"phone_bind": true
	},
	"alipaywealth": {
		"mapping_id": "8015209461024100000",
		"balance": 39250,
		"total_profit": 8567,
		"total_quotient": 0,
		"huabei_creditamount": 711450,
		"huabei_totalcreditamount": 1000000
	},
	"deliveraddress": [{
			"name": "张三",
			"address": "浙江省杭州市西湖区蒋村街道",
			"province": "浙江",
			"city": "杭州",
			"default": true,
			"mapping_id": "8015209461024100000",
			"full_address": "文一西路767号西溪国际商务中心X栋XF",
			"zip_code": "310013",
			"phone_no": "13*******00"
		},
		{ ...
		}
	],
	"recentdeliveraddress": [{
			"province": "浙江",
			"city": "杭州",
			"trade_id": "139333695850780000",
			"trade_createtime": "2018-03-23T08:38:57.000+08",
			"actual_fee": 2200,
			"deliver_name": "张三",
			"deliver_mobilephone": "13695810000",
			"deliver_address": "浙江省 杭州市 西湖区 蒋村街道 蒋村花园如意苑1栋一单元109",
			"deliver_postcode": "310013",
			"invoice_name": "个人"
		},
		{ ...
		}
	],
	"tradedetails": [{
			"mapping_id": "8015209461024140396",
			"trade_id": "139333695850780000",
			"trade_status": "TRADE_FINISHED",
			"trade_createtime": "2018-03-15T12:44:16.000+08",
			"actual_fee": 17700,
			"seller_id": 1785592653,
			"seller_nick": "贝蜜儿深圳专卖店",
			"seller_shopname": "贝蜜儿深圳专卖店",
			"trade_text": "交易成功",
			"sub_orders": [{
					"quantity": 3,
					"mapping_id": "8015209461024140396",
					"trade_id": "139333695850780000",
					"item_id": "123123123123",
					"item_url": "//item.taobao.com/item.htm?id=38687534535&_u=t8bovau4110",
					"item_pic": "//img.alichd.com/item.htm?id=38687534535&_u=t8bovau4110!!0-item_pic.jpg_80x80.jpg",
					"item_name": "贝蜜儿 钙铁锌粉婴儿婴幼儿童宝宝补钙补铁补锌乳钙 婴儿钙镁锌",
					"original": 7400,
					"real_total": 5900,
					"cid_level1": "500133232",
					"cid_level2": "50016097",
					"cname_level1": "婴幼儿营养品",
					"cname_level2": "钙铁锌"
				}
			]
		}
	]
}

```

### 2、报告数据 --- ReportData

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
| `basic_info` | 基本信息 | BasicInfo | 否 | |
| `wealth_info` | 财富信息 |WealthInfo |否 | |
| `address_analysis`| 地址分析 |AddressAnalysis |否 | |
| `consumption_analysis`| 消费分析 |ConsumptionAnalysis|否||
| `new_analysis`| 类目消费分析 |NewAnalysis|否||

#### 2.1、基本信息 --- BasicInfo

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
| `user_and_account_basic_info` | 用户基本信息 | UserAndAccountBasicInfo | 否 | |

##### 2.1.1、用户基本信息 --- UserAndAccountBasicInfo

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`taobao_name`|淘宝中该用户的真实姓名|string|是||
|`taobao_email`|淘宝中该用户绑定的邮箱|string|是||
|`taobao_phone_number`|淘宝中该用户绑定的手机号码|string|是||
|`alipay_account`|淘宝中该用户绑定的支付宝账户|string|是||
|`taobao_vip_level`|该用户的淘宝等级，vip等级分为:无等级(-1)和0~6级|string|是||
|`taobao_vip_count`|该用户的淘宝VIP值;vip值约等于购物金额|string|是||
|`gender`|性别|string|是||
|`birthday`|生日|string|是||
|`first_ordertime`|第一笔交易时间|string|是||
|`tao_score`|淘气值|string|是||
|`account_auth`|是否实名认证|string|是||

#### 2.2、财富信息 --- wealth_info

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`totalssets`|总资产|TotalsSets|是||

##### 2.2.1、总资产 --- TotalsSets

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`balance`|该用户支付宝账户余额金额|string|是||
|`yue_e_bao_amt`|该用户余额宝账户金额|string|是||
|`total_profit`|该用户支付宝历史累计收益金额|string|是||
|`huai_bei_limit`|当前该用户花呗的授信额度|string|是||
|`huai_bei_can_use_limit`|当前该用户花呗的可用授信额度|string|是||
|`taobao_zmscore`|支付宝的芝麻分|string|是||
|`taobao_jiebei_amount`|支付宝的借呗总额度|string|是||
|`taobao_jiebie_available_amount`|支付宝的借呗可用额度|string|是||

#### 2.3、地址分析 --- AddressAnalysis

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`fundamental_point_analysis`|基本点分析|FundamentalPointAnalysis|是||
|`commonly_used_address`|常用地址|CommonlyUsedAddress|是||
|`receipt_details`|收件详细信息|ReceiptDetails|是||

##### 2.3.1、基本点分析 --- FundamentalPointAnalysis

> 字段结构以接口返回为准

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`self_address_change(7d/30d/60d/90d)`||string|是|根据该用户本人(近7天/近30天/近60天/近90天)收货地址的数量判断;变化频繁:本人使用地址数量>5;较频繁:5>=本人使用地址数量>2，稳 定:2>=本人使用地址数量>0;无本人使用的收货地址:本人使用地址数 量=0;本人:若淘宝订单中的收货人姓名与该用户在淘宝中的真实姓名匹 配，则判断为’本人’;否则，判断为’非本人’|
|`self_city_change(7d/30d/60d/90d)`||string|是|根据该用户本人(近7天/近30天/近60天/近90天)收货地址对应的城市数量 判断;变化频繁:本人使用地址的城市数量>2，较频繁:2>=本人使用地 址的城市数量>1，稳定:本人使用地址的城市数量=1，无本人使用的收 货地址:本人使用地址的城市数量=0;本人:若淘宝订单中的收货人姓名 与该用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断 为’非本人’|
|`nonself_address_change(7d/30d/60d/90d)`||string|是|根据非用户本人为收货人(近7天/近30天/近60天/近90天)的地址数量判 断:变化频繁:非本人为收件人使用地址数量>5，较频繁:5>=非本人为 收件人使用地址数量>2，稳定: 2>=非本人为收件人使用地址数量>0无 非本人使用的收货地址:非本人为收件人使用地址数量=0;本人:若淘宝 订单中的收货人姓名与该用户在淘宝中的真实姓名匹配，则判断为’本 人’;否则，判断为’非本人’|
|`self_address_cnt(7d/30d/60d/90d)`||string|是|该用户交易已完成，且收货人为其本人的订单中，(近7天/近30天/近60 天/近90天)不同的收货地址数量;本人:若淘宝订单中的收货人姓名与该 用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断为’非本 人’;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|
|`avg_self_address_cnt(7d/30d/60d/90d)`||string|是|(近7天/近30天/近60天/近90天)本人收货订单数量/(近7天/近30天/近60 天/近90天)本人使用地址数量|
|`self_city_cnt(7d/30d/60d/90d)`||string|是|该用户交易已完成，且收货人姓名为其本人的订单中，(近7天/近30天/近 60天/近90天)地址中的不同城市数量;本人:若淘宝订单中的收货人姓名 与该用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断 为’非本人’;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|
|`avg_self_city_cnt(7d/30d/60d/90d)`||string|是|(近7天/近30天/近60天/近90天)本人收货订单数量/(近7天/近30天/近60 天/近90天)本人使用地址的城市数量|
|`nonself_address_cnt(7d/30d/60d/90d)`||string|是|该用户交易已完成，且收货人姓名不是其本人的订单中，(近7天/近30天/ 近60天/近90天)不同地址的数量;本人:若淘宝订单中的收货人姓名与该 用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断为’非本 人’交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|
|`avg_nonself_address_cnt(7d/30d/60d/90d)`||string|是|(近7天/近30天/近60天/近90天)非本人收货订单数量/(近7天/近30天/近60天/近90天)非本人收件人使用地址数量|

##### 2.3.2、常用地址 --- CommonlyUsedAddress

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`deliver_address`||map&lt;string,string&gt;|是|该用户的淘宝订单中，收货次数Top n对应的收货地址|
|`deliver_city`||map&lt;string,string&gt;|是|Top n 的收货地址对应的城市|
|`deliver_address_type`||map&lt;string,string&gt;|是|Top n 的收货地址对应的地址类型;地址类型包括:公司、住宅、学校、酒店、代理网点、其他|
|`use_month`||map&lt;string,string&gt;|是|Top n 的收货地址，对应的最近一次订单时间与最早一次订单时间的月份差|
|`last_deliver_past_cur`||map&lt;string,string&gt;|是|Top n 的收货地址，对应的最近一次订单时间与当前时间的天数差值|
|`first_deliver_time`||map&lt;string,string&gt;|是|Top n 的收货地址，最早一次的订单时间|
|`last_deliver_time`||map&lt;string,string&gt;|是|Top n 的收货地址，最近一次的订单时间|
|`deliver_name`||map&lt;string,string&gt;|是|Top n 的收货地址对应的收货人姓名|
|`deliver_phone`||map&lt;string,string&gt;|是|Top n 的收货地址对应的收货人的电话号码|
|`deliver_amt`||map&lt;string,string&gt;|是|Top n 的收货地址对应的订单金额之和|
|`deliver_cnt`||map&lt;string,string&gt;|是|Top n 的收货地址对应的订单数量之和|
|`receiving_amt`||map&lt;string,string&gt;|是|Top n 的收货地址对应的订单金额之和|
|`receiving_cnt`||map&lt;string,string&gt;|是|Top n 的收货地址对应的订单数量之和|

##### 2.3.3、收件详细信息 --- ReceiptDetails

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`max_deliver_name`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的收货人姓名|
|`max_deliver_phone`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的收货人的电话号码|
|`max_deliver_address`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的收货人对应的收货地址|
|`max_deliver_city`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的城市|
|`is_default`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的收货人姓名，是否与淘宝默认地址中的收货人姓名匹配|
|`max_cnt`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的收货人对应的收货订单数|
|`default_deliver_cnt`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，默认收件人的收货数量|
|`max_deliver_city_cnt`||map&lt;string,string&gt;|是|最近*个月，该用户交易已完成的订单中，收货数量最多的城市对应的收货数量|

#### 2.4、消费分析 --- ConsumptionAnalysis

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`total_consumption`|总体消费 |TotalConsumption|是||
|`receiving_consumption`|本人收货消费|ReceivingConsumption|是||
|`special_consumption`|特殊品消费|SpecialConsumption|是||

##### 2.4.1、总体消费 --- TotalConsumption

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`total_consum_amt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成的订单的金额之和;交易已完成的订单:指淘宝中订单的交易状态为’已 完成’的订单|
|`total_consum_times`||map&lt;string,string&gt;|是|某一统计月份，交易已完成的订单的数量之和;交易已完成的订单:指淘宝中订单的交易状态为’已 完成’的订单|
|`total_category_cnt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成的订单的消费品种类数量;消费品类分为:家居、彩票、汽车用品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;交易已完成的订单:指淘宝中订单的交 易状态为’已完成’的订单|

##### 2.4.2、本人收货消费 --- ReceivingConsumption

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`self_consum_amt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且本人收货的订单的金额之和;本人:若淘宝订单中的收货人姓名与该用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断为’非本人’;交易已完成的订单:指 淘宝中订单的交易状态为’已完成’的订单|
|`self_consum_times`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且本人收货的订单的数量之和;本人:若淘宝订单中的收货人姓名与该用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断为’非本人’;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|
|`self_category_cnt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且本人收货的订单的消费品种类数量;消费品类分为:家居、彩票、汽车 用品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;本人:若淘宝订单中的收货人姓 名与该用户在淘宝中的真实姓名匹配，则判断为’本人’;否则，判断为’非本人’;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|

##### 2.4.3、特殊品消费 --- SpecialConsumption

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`virtual_goods_amt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且消费品类为游戏、话费/流量的订单金额之和;消费品类分为:家居、彩 票、汽车用品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;交易已完成的订单:指 淘宝中订单的交易状态为’已完成’的订单|
|`virtual_goods_rate`||map&lt;string,string&gt;|是|(虚拟物品消费金额/消费金额)*100|
|`virtual_goods_cnt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且消费品类为游戏、话费/流量的订单数量之和;消费品类分为:家居、彩 票、汽车用品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;已完成的订单:指淘宝 中订单的交易状态为’已完成’的订单|
|`lottery_amt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且消费品类为彩票的订单金额之和;消费品类分为:家居、彩票、汽车用 品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|
|`lottery_rate`||map&lt;string,string&gt;|是|(彩票消费金额/消费金额)*100|
|`lottery_cnt`||map&lt;string,string&gt;|是|某一统计月份，交易已完成且消费品类为彩票的订单数量之和;消费品类分为:家居、彩票、汽车用 品、游戏、生活缴费、电影票、航旅、话费/流量、其他消费交易;交易已完成的订单:指淘宝中订单的交易状态为’已完成’的订单|

#### 2.5、类目消费分析 --- NewAnalysis

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`category_info`|类目分析|CategoryInfo|是||
|`trade_info`| 新增消费分析|TradeInfo|是|| 

##### 2.5.1、类目分析 --- CategoryInfo

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`taobao_category_freq_tradeid_30d`||list&lt;map&lt;string,string&gt;&gt;|是|30天内不同订单商品的个数|
|`taobao_category_cnt_itemname_30d`||list&lt;map&lt;string,string&gt;&gt;|是|30天内不同商品的个数|
|`taobao_category_cnt_tradeid_30d`||list&lt;map&lt;string,string&gt;&gt;|是|30天内不同订单的个数|
|`taobao_category_sum_realtotal_30d`||list&lt;map&lt;string,string&gt;&gt;|是|30天内商品消费总额度|
|`taobao_category_ratio_freq_tradeid_30d`||list&lt;map&lt;string,string&gt;&gt;|是|30天内订单商品的个数占比|
|`taobao_category_cnt_tradeid_150d`||list&lt;map&lt;string,string&gt;&gt;|是|150天内不同订单的个数|
|`taobao_category_freq_tradeid_150d`||list&lt;map&lt;string,string&gt;&gt;|是|150天内不同订单商品的个数|
|`taobao_category_cnt_itemname_150d`||list&lt;map&lt;string,string&gt;&gt;|是|150天内不同商品的个数|
|`taobao_category_sum_realtotal_150d`||list&lt;map&lt;string,string&gt;&gt;|是|150天内商品消费总额度|
|`taobao_category_ratio_freq_tradeid_150d`||list&lt;map&lt;string,string&gt;&gt;|是|150天内订单商品的个数占比|

##### 2.5.2、新增消费分析 --- TradeInfo

| 参数名 | 参数名称 | 参数类型 | 是否允许为空 | 备注 |
| --- | --- | --- | --- | --- |
|`tb_userinfo_vipcount`||string|是|成长值|
|`tb_userinfo_sum_vipcount_tmallapass`||string|是|总成长值|
|`tb_userinfo_length_day_firstorder`||string|是|最早一笔订单记录距今天数|
|`tb_so_cnt_cglevel1_success_150d`||string|是|150天内交易成功且不同一级类目ID的个数|
|`tb_so_cnt_cglevel1_150d`||string|是|150天内不同一级类目ID的个数|
|`tb_so_cnt_cglevel2_success_150d`||string|是|150天内交易成功且不同二级类目ID的个数|
|`tb_so_cnt_cglevel2_150d`||string|是|150天内不同二级类目ID的个数|
|`tb_ti_freq_success_150d`||string|是|150天内交易成功的记录条数|
|`tb_ti_ratio_freq_success_150d`||string|是|150天内交易成功的记录占比|
|`tb_ti_length_first_last_success_150d`||string|是|150天内交易成功里最早一条距最后一条记录的天数|
|`tb_ti_freq_day_success_150d`||string|是|150天内交易成功且发生在8:00~17:59的次数|
|`tb_ti_freq_weekday_success_150d`||string|是|150天内交易成功且发生在工作日的次数|
|`tb_ti_cnt_sellerid_success_150d`||string|是|150天内交易成功且不同卖家ID个数|
|`tb_ti_cnt_tradeid_success_150d`||string|是|150天内交易成功且不同交易ID个数|
|`tb_ti_max_actualfee_success_150d`||string|是|150天内交易成功且最大订单金额|
|`tb_ti_avg_actualfee_success_150d`||string|是|150天内交易成功的平均订单金额|
|`tb_ti_sum_actualfee_success_150d`||string|是|150天内交易成功的订单金额总和|
|`tb_so_sum_realtotal_virtual_150d`||string|是|150天内虚拟商品的交易金额总和|
|`tb_so_ratio_sum_realtotal_virtual_150d`||string|是|150天内虚拟商品的交易金额总和占比|
|`tb_so_freq_record_virtual_150d`||string|是|150天内虚拟商品的次数|
|`tb_so_freq_success_150d`||string|是|150天内交易成功的次数|
|`tb_so_ratio_freq_success_150d`||string|是|150天内交易成功次数的占比|
|`tb_so_cnt_itemid_success_150d`||string|是|150天内交易成功且不同商品ID的个数|
|`tb_so_max_realtotal_success_150d`||string|是|150天内交易成功且最大商品真实交易价格金额|
|`tb_so_avg_realtotal_success_150d`||string|是|150天内交易成功的平均商品真实交易价格金额|
|`tb_so_sum_realtotal_success_150d`||string|是|150天内交易成功的商品真实交易价格金额总和|
|`tb_so_sum_realtotal_virtual_succes_150d`||string|是|150天内交易成功的虚拟商品的交易金额总和|
|`tb_so_ratio_realtotal_virtual_150d`||string|是|150天内交易成功的虚拟商品的交易金额总和占比|
|`tb_so_freq_record_virtual_success_150d`||string|是|150天内交易成功的虚拟商品的次数|
|`taobao_ti_sum_actualfee_30d`||string|是|近30天内消费额度总和|
|`taobao_ti_sum_actualfee_90d`||string|是|近90天内消费额度总和|
|`taobao_ti_sum_actualfee_150d`||string|是|近150天内消费额度总和|
|`taobao_ti_sum_actualfee_rank_30d`||string|是|近30天内消费水平区间范围|
|`taobao_ti_sum_actualfee_rank_90d`||string|是|近90天内消费水平区间范围|
|`taobao_ti_sum_actualfee_rank_150d`||string|是|近150天内消费水平区间范围|

- 示例

``` 

{
	"basic_info": {
		"user_and_account_basic_info": {
			"taobao_name": "string",
			"taobao_email": "string",
			"taobao_phone_number": "string",
			"alipay_account": "string",
			"taobao_vip_level": "string",
			"taobao_vip_count": "string",
			"gender": "string",
			"birthday": "string",
			"first_ordertime": "string",
			"tao_score": "string",
			"account_auth": "string"
		}
	},
	"wealth_info": {
		"totalssets": {
			"balance": "string",
			"yue_e_bao_amt": "string",
			"total_profit": "string",
			"huai_bei_limit": "string",
			"huai_bei_can_use_limit": "string",
			"taobao_zmscore": "string",
			"taobao_jiebei_amount": "string",
			"taobao_jiebie_available_amount": "string"
		}
	},
	"address_analysis": {
		"fundamental_point_analysis": {
			"self_address_change": "string",
			"self_address_change_7d": "string",
			"self_address_change_30d": "string",
			"self_address_change_60d": "string",
			"self_address_change_90d": "string",
			"self_city_change": "string",
			"self_city_change_7d": "string",
			"self_city_change_30d": "string",
			"self_city_change_60d": "string",
			"self_city_change_90d": "string",
			"nonself_address_change": "string",
			"nonself_address_change_7d": "string",
			"nonself_address_change_30d": "string",
			"nonself_address_change_60d": "string",
			"nonself_address_change_90d": "string",
			"self_address_cnt": "string",
			"self_address_cnt_7d": "string",
			"self_address_cnt_30d": "string",
			"self_address_cnt_60d": "string",
			"self_address_cnt_90d": "string",
			"avg_self_address_cnt": "string",
			"avg_self_address_cnt_7d": "string",
			"avg_self_address_cnt_30d": "string",
			"avg_self_address_cnt_60d": "string",
			"avg_self_address_cnt_90d": "string",
			"self_city_cnt": "string",
			"self_city_cnt_7d": "string",
			"self_city_cnt_30d": "string",
			"self_city_cnt_60d": "string",
			"self_city_cnt_90d": "string",
			"avg_self_city_cnt": "string",
			"avg_self_city_cnt_7d": "string",
			"avg_self_city_cnt_30d": "string",
			"avg_self_city_cnt_60d": "string",
			"avg_self_city_cnt_90d": "string",
			"nonself_address_cnt": "string",
			"nonself_address_cnt_7d": "string",
			"nonself_address_cnt_30d": "string",
			"nonself_address_cnt_60d": "string",
			"nonself_address_cnt_90d": "string",
			"avg_nonself_address_cnt": "string",
			"avg_nonself_address_cnt_7d": "string",
			"avg_nonself_address_cnt_30d": "string",
			"avg_nonself_address_cnt_60d": "string",
			"avg_nonself_address_cnt_90d": "string"
		},
		"commonly_used_address": {
			"deliver_address": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_city": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_address_type": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"use_month": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"last_deliver_past_cur": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"first_deliver_time": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"last_deliver_time": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_name": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_phone": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_amt": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"deliver_cnt": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"receiving_amt": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			},
			"receiving_cnt": {
				"top1": "string",
				"top2": "string",
				"top3": "string"
			}
		},
		"receipt_details": {
			"max_deliver_name_3": "string",
			"max_deliver_name_6": "string",
			"max_deliver_phone_3": "string",
			"max_deliver_phone_6": "string",
			"max_deliver_address_3": "string",
			"max_deliver_address_6": "string",
			"max_deliver_city_3": "string",
			"max_deliver_city_6": "string",
			"is_default_3": "string",
			"is_default_6": "string",
			"max_cnt_3": "string",
			"max_cnt_6": "string",
			"default_deliver_cnt_3": "string",
			"default_deliver_cnt_6": "string",
			"max_deliver_city_cnt_3": "string",
			"max_deliver_city_cnt_6": "string"
		}
	},
	"consumption_analysis": {
		"total_consumption": {
			"total_consum_amt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"total_consum_times": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"total_category_cnt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			}
		},
		"receiving_consumption": {
			"self_consum_amt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"self_consum_times": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"self_category_cnt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			}
		},
		"special_consumption": {
			"virtual_goods_amt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"virtual_goods_rate": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"virtual_goods_cnt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"lottery_amt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"lottery_rate": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			},
			"lottery_cnt": {
				"2018-04": "string",
				"2018-03": "string",
				"2018-02": "string",
				"2018-01": "string",
				"2017-12": "string",
				"2017-11": "string",
				"sum": "string"
			}
		}
	},
	"new_analysis": {
		"category_info": {
			"taobao_category_freq_tradeid_30d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_cnt_itemname_30d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_cnt_tradeid_30d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_sum_realtotal_30d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_ratio_freq_tradeid_30d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_cnt_tradeid_150d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_freq_tradeid_150d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_cnt_itemname_150d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_sum_realtotal_150d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			],
			"taobao_category_ratio_freq_tradeid_150d": [{
					"key": "string",
					"value": "string"
				},
				{ ...}
			]
		},
		"trade_info": {
			"tb_userinfo_vipcount": "string",
			"tb_userinfo_sum_vipcount_tmallapass": "string",
			"tb_userinfo_length_day_firstorder": "string",
			"tb_so_cnt_cglevel1_success_150d": "string",
			"tb_so_cnt_cglevel1_150d": "string",
			"tb_so_cnt_cglevel2_success_150d": "string",
			"tb_so_cnt_cglevel2_150d": "string",
			"tb_ti_freq_success_150d": "string",
			"tb_ti_ratio_freq_success_150d": "string",
			"tb_ti_length_first_last_success_150d": "string",
			"tb_ti_freq_day_success_150d": "string",
			"tb_ti_freq_weekday_success_150d": "string",
			"tb_ti_cnt_sellerid_success_150d": "string",
			"tb_ti_cnt_tradeid_success_150d": "string",
			"tb_ti_max_actualfee_success_150d": "string",
			"tb_ti_avg_actualfee_success_150d": "string",
			"tb_ti_sum_actualfee_success_150d": "string",
			"tb_so_sum_realtotal_virtual_150d": "string",
			"tb_so_ratio_sum_realtotal_virtual_150d": "string",
			"tb_so_freq_record_virtual_150d": "string",
			"tb_so_freq_success_150d": "string",
			"tb_so_ratio_freq_success_150d": "string",
			"tb_so_cnt_itemid_success_150d": "string",
			"tb_so_max_realtotal_success_150d": "string",
			"tb_so_avg_realtotal_success_150d": "string",
			"tb_so_sum_realtotal_success_150d": "string",
			"tb_so_sum_realtotal_virtual_succes_150d": "string",
			"tb_so_ratio_realtotal_virtual_150d": "string",
			"tb_so_freq_record_virtual_success_150d": "string",
			"taobao_ti_sum_actualfee_30d": "string",
			"taobao_ti_sum_actualfee_90d": "string",
			"taobao_ti_sum_actualfee_150d": "string",
			"taobao_ti_sum_actualfee_rank_30d": "string",
			"taobao_ti_sum_actualfee_rank_90d": "string",
			"taobao_ti_sum_actualfee_rank_150d": "string",
		}
	}
}

```