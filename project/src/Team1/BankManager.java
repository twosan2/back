package Team1;

public class BankManager {
	private String name;//���ݸ�
	private String bank;// �����
	private int term;// ���ݱⰣ
	private int maxsave;// �ִ� ���԰��� �ݾ� (������ 0)
	private int minsave;// �ּ� ���԰��� �ݾ�
	private boolean interests_calculation; // ���� ��� ��� (true:�ܸ� , false:����)
	private boolean accumulation;// �������� ����
	private int basic_interest;// �⺻�ݸ�
	private int upgrade_interest;// ���ݸ�
	private int variable_interest;// �����ݸ�
	private int upgrade_rate;// ��� ���� (�����Ա��� upgrade_rate ���� Ŀ���Ѵ� )
}
