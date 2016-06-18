package demo.mcx.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "acct_role", catalog = "work")
public class AcctRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2341818593980450829L;
	private String id;
	private String name;
	private Set<AcctUser> acctUsers = new HashSet<AcctUser>(0);
	private Set<AcctAuthority> acctAuthorities = new HashSet<AcctAuthority>(0);

	public AcctRole() {
		
	}

	public AcctRole(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public AcctRole(String id, String name, Set<AcctUser> acctUsers,
			Set<AcctAuthority> acctAuthorities) {
		this.id = id;
		this.name = name;
		this.acctUsers = acctUsers;
		this.acctAuthorities = acctAuthorities;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 /* 
     * @ManyToMany 注释表示Teacher 是多对多关系的一端。 
     * @JoinTable 描述了多对多关系的数据表关系，name属性指定中间表名称。 
     * joinColumns 定义中间表与acct_role 表的外键关系，中间表acct_user_role的role_id 列是acct_role 表的主键列对应的外键列。 
     * inverseJoinColumns 属性定义了中间表与另外一端(user)的外键关系。 
     */  
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "acct_user_role", catalog = "work", 
	joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<AcctUser> getAcctUsers() {
		return this.acctUsers;
	}

	public void setAcctUsers(Set<AcctUser> acctUsers) {
		this.acctUsers = acctUsers;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "acct_role_authority", catalog = "work", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) })
	public Set<AcctAuthority> getAcctAuthorities() {
		return this.acctAuthorities;
	}

	public void setAcctAuthorities(Set<AcctAuthority> acctAuthorities) {
		this.acctAuthorities = acctAuthorities;
	}

}
