package br.com.geektechnology.chamadostecnicosinternet.domain.model.chamado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonRootName("Chamados")
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table( name = "chamados")
public class Chamado {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@JoinColumn(name = "atendente_id", nullable = false)
//	@JsonProperty("atendente-id")
//	@NotNull
//	@ManyToOne
//	private Colaborador atendente;

//	@JoinColumn(name = "tecnico_id", nullable = false)
//	@JsonProperty("tecnico-id")
//	@NotNull
//	@ManyToOne
//	private Colaborador tecnico;

	@JsonProperty("meio-solicitacao-id")
	@JoinColumn(name = "meio_solicitacao_id", nullable = false)
	@ManyToOne
	private MeioSolicitacao meioSolicitacaoId;

	@JsonProperty("relato-cliente")
	@Column(name = "relato_cliente", nullable = false)
	private String relatoCliente;

	@Enumerated(EnumType.STRING)
	@Column(name = "nivel")
	@JsonProperty(value = "nivel")
	private Nivel nivel;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	@JsonProperty("status")
	private Status status;

	@JsonProperty("observacao")
	@Column(name = "observacao", nullable = true)
	private String observacao;

//	@JsonProperty("reclamacao-id")
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name = "reclamacao_id", nullable = false)
//	private TituloProblemaEncontrado reclamacao;

	@JsonProperty("identificador-protocolo")
	@Column(name = "identificador_protocolo", nullable = false, length = 14)
	private String identificadorProtocolo;

//	@JsonProperty("cliente_id")
//	@JoinColumn(name = "cliente_id", nullable = false)
//	@ManyToOne
//	@NotNull
//	private Pessoa cliente;

	@JsonProperty("conta-cliente")
	@Column(name = "conta_cliente", nullable = true)
	private String contaCliente;

//	@Basic
//	@JsonProperty("endereco-cliente")
//	@JoinColumn(name = "endereco_id")
//	@ManyToOne
//	@NotNull
//	private Endereco enderecoCliente;

	@JsonProperty("descricao-problema-encontrado")
	@Column(name = "descricao_problema_encontrado", nullable = true)
	private String descricaoProblemaEncontrado;

//	@JsonProperty("data-hora-abertura-chamado")
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonIgnore
	@CreationTimestamp
	@Column(name = "data_hora_abertura_chamado", columnDefinition = "datetime", nullable = false)
	private LocalDateTime dataHoraAberturaChamado;

	@JsonProperty(value = "data-hora-fechamento-chamado")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "data_hora_fechamento_chamado", nullable = true)
	private LocalDateTime dataHoraFechamentoChamado;

	@PrePersist
	private void prePersistMethod() {
		gerarNumeroProtocolo();
		// gerarDataHoraAberturaChamado();
		gerarStatusInicial();
	}

	private void gerarNumeroProtocolo() {
		// System.out.println(ZoneId.getAvailableZoneIds());
		// LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));
		if (this.identificadorProtocolo == null) {
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyymmddhhmmss");
			this.identificadorProtocolo = String.format("%s", dateTime.format(formatter));
		}
	}

//	private void gerarDataHoraAberturaChamado() {
//		this.dataHoraAberturaChamado = LocalDateTime.now();
//	}

	private void gerarStatusInicial() {
		this.status = Status.ABERTO;
	}
	
	
//	public Date getSubmissionDateConverted(String timezone) throws ParseException {
//		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//		return dateFormat.parse(this.date);
//		}
//		public void setSubmissionDate(Date date, String timezone) {
//		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
//		this.date = dateFormat.format(date);
//		}
}
