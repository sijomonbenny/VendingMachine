/* Name of the Author : SIJOMON BENNY
 * Department         : MCA
 * E-mail			  : sijomonbenny@outlook.com
 * Date of Modified   : 29/09/2020
 */
/* Model Name : Item
 * package : com.baton.vm.model
 * properties : Item Id, Item Name, Item Price
 */

package com.baton.vm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_tbl")
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	private double price;

	public Item() {
	}

	public Item(int itemId, String itemName, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
