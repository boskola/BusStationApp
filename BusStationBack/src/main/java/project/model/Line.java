package project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "line")
public class Line {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int seatsNumber;
	
	@Column
	private double ticketPrice;
	
	@Column
	private String departureTime;
	
	@Column(nullable = false)
	private String destination;
	
	@ManyToOne
	private Operator operator;
	
	public Line() {}

	public Line(Long id, int seatsNumber, double ticketPrice, String departureTime, String destination,
			Operator operator) {
		super();
		this.id = id;
		this.seatsNumber = seatsNumber;
		this.ticketPrice = ticketPrice;
		this.departureTime = departureTime;
		this.destination = destination;
		this.operator = operator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
		if(operator != null && !operator.getLines().contains(this)) {
			operator.getLines().add(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Line [id=" + id + ", seatsNumber=" + seatsNumber + ", ticketPrice=" + ticketPrice + ", departureTime="
				+ departureTime + ", destination=" + destination + ", operator=" + operator + "]";
	}

}
