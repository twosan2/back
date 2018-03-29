package Team1;

public class BankManager {
	private String name;//적금명
	private String bank;// 은행명
	private int term;// 적금기간
	private int maxsave;// 최대 납입가능 금액 (없을시 0)
	private int minsave;// 최소 납입가능 금액
	private boolean interests_calculation; // 이자 계산 방식 (true:단리 , false:복리)
	private boolean accumulation;// 자유적립 유무
	private int basic_interest;// 기본금리
	private int upgrade_interest;// 우대금리
	private int variable_interest;// 변동금리
	private int upgrade_rate;// 우대 조건 (월납입금이 upgrade_rate 보다 커야한다 )
}
