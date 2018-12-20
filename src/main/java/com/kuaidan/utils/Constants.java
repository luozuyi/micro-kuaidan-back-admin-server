package com.kuaidan.utils;

public abstract class Constants {
	
	/**
	 * 错误
	 */
	public static String ERROR = "-2";
	/**
	 * 失败
	 */
	public static String FAIL = "-1";
	/**
	 * 成功
	 */
	public static String SUCCESS = "0";
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	
	/**
	 * fastdfs server ip
	 */
	public static final String FASTDFS_PATH = "fastdfsIp";
	/**
	 * fastdfs server ip address
	 */
	public static final String FASTDFS_SERVER_IP = "http://192.168.13.249";

	public static final String FASTDFS_IP = "http://47.96.231.230";

	public static final String FASTDFS_SERVER_IP_NEW = "192.168.13.249";
	/**
	 * elasticsearch server ip address
	 */
	public static final String ELASTICSEARCH_SERVER_IP = "http://47.96.1.66";
	
	public static final String ACTIVITY_IP = "http://47.96.1.66:8080";

	public static final String PICTUREEXTENTION = "JPG,jpg,PNG,png";

	public static final String TXT = "TXT,txt";
	/**
	 * 章节索引
	 */
	public static final String BOOKCHAPTERDIRECTORYINDEX = "chapterDirectory";
	/**
	 * 所有内容
	 */
	public static final String BOOKCONTENT = "content";
	/**
	 * 书籍来源
	 */
	public enum BookSouce{
		UPLOAD("1","上传"), SPIDER("2","爬虫"),
		PUBLISH("3","出版"), NONE("4","无");
		private String source ;
		private String info;

		BookSouce(String source, String info) {
			this.source = source;
			this.info = info;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 书籍状态
	 */
	public enum BookStatus{
		WAITAUDIT("0","待审核"),
		NOPASS("1","不通过"),
		HASUP("2","已上架"),
		HASDOWN("3","已下架"),
		NONE("4","无");

		private String status ;
		private String info;

		BookStatus(String status, String info) {
			this.status = status;
			this.info = info;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 管理员是否禁用
	 */
	public enum AdminIsDisable{
		DISABLE("1","是"),
		UNDISABLE("0","否");
		private String isDisable;
		private String info;

		AdminIsDisable(String isDisable, String info) {
			this.isDisable = isDisable;
			this.info = info;
		}

		public String getIsDisable() {
			return isDisable;
		}

		public void setIsDisable(String isDisable) {
			this.isDisable = isDisable;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 广告版位是否禁用
	 */
	public enum AdvertiseLocationIsForbidden{
		UNFORBIDDEN("0","不禁用"),
		FORBIDDEN("1","禁用");

		private String isForbidden;
		private String info;

		AdvertiseLocationIsForbidden(String isForbidden, String info) {
			this.isForbidden = isForbidden;
			this.info = info;
		}

		public String getIsForbidden() {
			return isForbidden;
		}

		public void setIsForbidden(String isForbidden) {
			this.isForbidden = isForbidden;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 广告是否禁用
	 */
	public enum AdvertiseIsForbidden{
		UNFORBIDDEN("0","不禁用"),
		FORBIDDEN("1","禁用");

		private String isForbidden;
		private String info;

		AdvertiseIsForbidden(String isForbidden, String info) {
			this.isForbidden = isForbidden;
			this.info = info;
		}

		public String getIsForbidden() {
			return isForbidden;
		}

		public void setIsForbidden(String isForbidden) {
			this.isForbidden = isForbidden;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 举报状态
	 */
	public enum ReportCommentStatus{
		WAITADUIT("0","待审核"),
		PASS("1","通过"),
		UNPASS("2","不通过"),
		NONE("3","屏蔽");

		private String status;
		private String info;

		ReportCommentStatus(String status, String info) {
			this.status = status;
			this.info = info;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 删除标志位
	 */
	public enum DelFlag{
		NORMAL("0","正常"),
		DELETE("1","删除"),
		WAITTODELETE("2","待删除");

		private String type;
		private String info;

		DelFlag(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 审核结果
	 */
	public enum CheckResult{
		TYPE1(1,"通过"),
		TYPE2(2,"不通过");

		private Integer type;
		private String info;

		CheckResult(Integer type, String info) {
			this.type = type;
			this.info = info;
		}
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 审核结果
	 */
	public enum CheckType{
		TYPE1(1,"第一次审核"),
		TYPE2(2,"第二次审核");

		private Integer type;
		private String info;

		CheckType(Integer type, String info) {
			this.type = type;
			this.info = info;
		}
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否退还消费者保障金
	 */
	public enum IsReturnDeposit{
		RETURN("0","需要退还"),
		UNRETURN("1","不需要退还")
		;
		private String isReturn;
		private String info;

		IsReturnDeposit(String isReturn, String info) {
			this.isReturn = isReturn;
			this.info = info;
		}

		public String getIsReturn() {
			return isReturn;
		}

		public void setIsReturn(String isReturn) {
			this.isReturn = isReturn;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否退还技术年费
	 */
	public enum IsReturnTechServiceFee{
		RETURN("0","需要退还"),
		UNRETURN("1","不需要退还")
		;
		private String isReturn;
		private String info;
		IsReturnTechServiceFee(String isReturn, String info) {
			this.isReturn = isReturn;
			this.info = info;
		}

		public String getIsReturn() {
			return isReturn;
		}

		public void setIsReturn(String isReturn) {
			this.isReturn = isReturn;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 商城类型
	 */
	public enum ShopType{
		FLAGSHIPSTORE("0","旗舰店"),
		MONOPOLYSTORE("1","专营店"),
		MONOSALESTORE("2","专卖店")
		;
		private String type;
		private String info;

		ShopType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 商标类型
	 */
	public enum TrademarkType{
		R("0","R标"),
		TM("1","TM标")
		;
		private String type;
		private String info;

		TrademarkType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 商标是否转让
	 */
	public enum IsTransferTrademark{
		YES("0","是"),
		NO("1","否");
		private String type;
		private String info;

		IsTransferTrademark(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否带货
	 */
	public enum IsCarryGoods{
		CARRY("0","带货"),
		UNCARRY("1","不带货")
		;
		private String type;
		private String info;

		IsCarryGoods(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 纳税人性质
	 */
	public enum TaxPayerType{
		GENERAL("0","一般纳税人"),
		SMALLSCALE("1","小规模纳税人");
		private String type;
		private String info;

		TaxPayerType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否贷款
	 */
	public enum IsLoan{
		YES("0","有贷款"),
		NO("1","没贷款");
		private String type;
		private String info;

		IsLoan(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否完成营业额指标
	 */
	public enum IsCompletedTurnoverIndex{
		YES("0","完成"),
		NO("1","没有完成");
		private String type;
		private String info;

		IsCompletedTurnoverIndex(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 行业类型
	 */
	public enum IndustryType{
		TYPE0("0","服饰鞋包"),
		TYPE1("1","美容护理"),
		TYPE2("2","母婴用品"),
		TYPE3("3","3C数码类"),
		TYPE4("4","运动/户外"),
		TYPE5("5","家装家饰"),
		TYPE6("6","家居用品"),
		TYPE7("7","食品/保健"),
		TYPE8("8","珠宝/首饰"),
		TYPE9("9","游戏/话费"),
		TYPE10("10","生活服务"),
		TYPE11("11","汽车配件"),
		TYPE12("12","书籍音像"),
		TYPE13("13","玩乐/收藏"),
		TYPE14("14","万用百搭"),
		TYPE15("15","其他行业"),
		TYPE16("16","医药健康"),
		TYPE17("17","大家电")
		;
		private String type;
		private String info;

		IndustryType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 当前主营行业
	 */
	public enum CurrentMainCamp{
		TYPE0("0","服饰鞋包"),
		TYPE1("1","美容护理"),
		TYPE2("2","母婴用品"),
		TYPE3("3","3C数码类"),
		TYPE4("4","运动/户外"),
		TYPE5("5","家装家饰"),
		TYPE6("6","家居用品"),
		TYPE7("7","食品/保健"),
		TYPE8("8","珠宝/首饰"),
		TYPE9("9","游戏/话费"),
		TYPE10("10","生活服务"),
		TYPE11("11","汽车配件"),
		TYPE12("12","书籍音像"),
		TYPE13("13","玩乐/收藏"),
		TYPE14("14","万用百搭"),
		TYPE15("15","其他行业"),
		TYPE16("16","医药健康"),
		TYPE17("17","大家电")
		;
		private String type;
		private String info;

		CurrentMainCamp(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否可以过户
	 */
	public enum IsTransfer{
		YES("0","可以过户"),
		NO("1","不可以过户")
		;
		private String type;
		private String info;

		IsTransfer(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 是否有债务纠纷
	 */
	public enum IsDisputeOverObligation{
		YES("1","有债务纠纷"),
		NO("0","没有债务纠纷")
		;
		private String type;
		private String info;

		IsDisputeOverObligation(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 店铺资质
	 */
	public enum ShopQualification{
		TYPE1("1","正品保障"),
		TYPE2("2","消费者保障"),
		TYPE3("3","七天退换")
		;
		private String type;
		private String info;

		ShopQualification(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 店铺评分图标(1.低、2.持平、3.高)
	 */
	public enum ScoreIcon{
		TYPE1("1","低"),
		TYPE2("2","持平"),
		TYPE3("3","高")
		;
		private String type;
		private String info;

		ScoreIcon(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}


	/**
	 * 可以提供的证件
	 */
	public enum Credentials{
		TYPE1("1","身份证"),
		TYPE2("2","手持身份证"),
		TYPE3("3","营业执照"),
		TYPE4("4","手持营业执照")
		;
		private String type;
		private String info;

		Credentials(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * TM标是否入品牌库
	 */
	public enum IsTmTrademarkAddBrand{
		YES("0","是"),
		NO("1","否"),
		;
		private String type;
		private String info;

		IsTmTrademarkAddBrand(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 店铺在平台的状态
	 */
	public enum Status{
		ADUITING("0","审核中"),
		ADUITPASS("1","审核通过"),
		ADUITNOPASS("2","审核不通过"),
		DOWN("3","下架"),
		HASPAY("4","已付定金"),
		PAYMENT("5","已付全款"),
		TRANSFERING("6","交接中"),
		HASSALE("7","已售出")
		;
		private String type;
		private String info;

		Status(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 商标所属人
	 */
	public enum TrademarkOwner{
		TYPE0("0","个人"),
		TYPE1("1","公司"),
		;
		private String type;
		private String info;

		TrademarkOwner(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 订单状态
	 */
	public enum OrderStatus{
		TYPE0("0","待付款"),
		TYPE1("1","已付款"),
		TYPE2("2","交易成功"),
		TYPE3("3","已取消"),
		TYPE4("4","已终止")
		;
		private String type;
		private String info;

		OrderStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 订单冻结状态
	 */
	public enum TmallOrderFreezeStatus{
		TYPE0("0","冻结中"),
		TYPE1("1","已解冻")
		;
		private String type;
		private String info;

		TmallOrderFreezeStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 站内信状态
	 */
	public enum PlatformMessageStatus{
		TYPE0("0","未读"),
		TYPE1("1","已读");

		private String type;
		private String info;

		PlatformMessageStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}

	//资金模块
	/**
	 * 支付宝充值状态
	 */
	public enum AlipayStatus{
		TYPE0("0","审核中"),
		TYPE1("1","成功"),
		TYPE2("2","失败");

		private String type;
		private String info;

		AlipayStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 线下汇款记录状态
	 */
	public enum RemittanceStatus{
		TYPE0("0","审核中"),
		TYPE1("1","成功"),
		TYPE2("2","失败");

		private String type;
		private String info;

		RemittanceStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 收支明细类型
	 */
	public enum IncomeExpensesType{
		TYPE0("0","收入"),
		TYPE1("1","支出");

		private String type;
		private String info;

		IncomeExpensesType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 明细场景
	 */
	public enum IncomeExpensesMoneyScene{
		TYPE0("0","充值"),
		TYPE1("1","tmall订单支付"),
		TYPE2("2","提现"),
		TYPE3("3","tmall店铺售出"),
		TYPE4("4","tmall订单交易成功"),
		TYPE5("5","提现手续费"),
		TYPE6("6","佣金返利"),
		TYPE7("7","差价返利"),
		TYPE8("8","违约金调整返还");

		private String type;
		private String info;

		IncomeExpensesMoneyScene(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 *银行卡默认状态
	 */
	public enum MemberBankInfoIsDefault{
		TYPE0("0","默认"),
		TYPE1("1","不是默认");

		private String type;
		private String info;

		MemberBankInfoIsDefault(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 提现状态
	 */
	public enum WithdrawDepositStatus{
		TYPE0("0","审核中"),
		TYPE1("1","打款中"),
		TYPE2("2","成功"),
		TYPE3("3","失败");

		private String type;
		private String info;

		WithdrawDepositStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 提现冻结明细状态
	 */
	public enum WithdrawFreezeDetailStatus{
		TYPE0("0","冻结中"),
		TYPE1("1","已解冻");


		private String type;
		private String info;

		WithdrawFreezeDetailStatus(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 平台收支场景 0:服务费 1:佣金返利 2:违约金 3:违约金调整返还 4:提现手续费 5:银行手续费
	 */
	public enum PlatformFundDetailMoneyScene{
		TYPE0("0","服务费"),
		TYPE1("1","佣金返利"),
		TYPE2("2","违约金"),
		TYPE3("3","违约金调整返还"),
		TYPE4("4","提现手续费"),
		TYPE5("5","银行手续费");

		private String type;
		private String info;

		PlatformFundDetailMoneyScene(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 平台收支类型
	 */
	public enum PlatformFundDetailType{
		TYPE0("0","收入"),
		TYPE1("1","支出");

		private String type;
		private String info;

		PlatformFundDetailType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 平台收支关联类型
	 */
	public enum PlatformFundDetailRelationType{
		TYPE0("0","订单id"),
		TYPE1("1","提现id");

		private String type;
		private String info;

		PlatformFundDetailRelationType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	/**
	 * 会员资金调整记录收支类型 0:调整可用资金 1:调整冻结资金
	 */
	public enum MemberFundAdjustFundType{
		TYPE0("0","调整可用资金"),
		TYPE1("1","调整冻结资金");

		private String type;
		private String info;

		MemberFundAdjustFundType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 会员资金调整记录收支类型
	 */
	public enum MemberFundAdjustIncomeType{
		TYPE0("0","收入"),
		TYPE1("1","支出");

		private String type;
		private String info;

		MemberFundAdjustIncomeType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 会员资金调整记录关联类型
	 */
	public enum MemberFundAdjustRelationType{
		TYPE0("0","订单"),
		TYPE1("1","提现"),
		TYPE2("2","充值");

		private String type;
		private String info;

		MemberFundAdjustRelationType(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}
	/**
	 * 会员资金调整记录场景 0:佣金返利 1:差价返利 2:违约金调整返还 3:提现 4:支付宝充值 5:线下汇款
	 */
	public enum MemberFundAdjustMoneyScene{
		TYPE0("0","佣金返利"),
		TYPE1("1","差价返利"),
		TYPE2("2","违约金调整返还"),
		TYPE3("3","提现"),
		TYPE4("4","支付宝充值"),
		TYPE5("5","线下汇款");




		private String type;
		private String info;

		MemberFundAdjustMoneyScene(String type, String info) {
			this.type = type;
			this.info = info;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
	}

	public static void main(String[] args) {
		for (IndustryType i: IndustryType.values()) {
			System.out.println(i.getType()+","+i.getInfo());
		}
	}
}
