/* Name of the Author : SIJOMON BENNY
 * Department         : MCA
 * E-mail			  : sijomonbenny@outlook.com
 * Date of Modified   : 29/09/2020
 */
/* Model Name : Inventory
 * package : com.baton.vm.model
 * properties : Inventory, Item, Quantity
 */
package com.baton.vm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_tbl")
public class Inventory {

	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;

	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(name = "quantity")
	private int quantity;

	public Inventory() {
	}

	public Inventory(Item i, int qty) {
		this.item = i;
		this.quantity = qty;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
