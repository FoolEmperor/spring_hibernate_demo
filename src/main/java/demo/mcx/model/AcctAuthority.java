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

/**
 * 权限表
 */
@Entity
@Table(name = "acct_authority", catalog = "work")
public class AcctAuthority implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1495787682343110812L;
	private String id;
	private String name;
	private Set<AcctRole> acctRoles = new HashSet<AcctRole>(0);

	public AcctAuthority() {
		
	}

	public AcctAuthority(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public AcctAuthority(String id, String name, Set<AcctRole> acctRoles) {
		this.id = id;
		this.name = name;
		this.acctRoles = acctRoles;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "acct_role_authority", catalog = "work", 
	joinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<AcctRole> getAcctRoles() {
		return this.acctRoles;
	}

	public void setAcctRoles(Set<AcctRole> acctRoles) {
		this.acctRoles = acctRoles;
	}

}
