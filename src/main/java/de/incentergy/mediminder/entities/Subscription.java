package de.incentergy.mediminder.entities;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Class generated by: http://www.jsonschema2pojo.org/
 * 
 * Extended with example code from:
 * 
 * https://github.com/MartijnDwars/web-push/blob/master/doc/UsageExample.md
 * 
 * @author manuel
 *
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "endpoint", "key", "auth" })
public class Subscription {

	@JsonProperty("endpoint")
	private String endpoint;

	@Id
	@JsonProperty("key")
	private String key;
	@JsonProperty("auth")
	private String auth;
	@JsonIgnore
	@Transient
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("endpoint")
	public String getEndpoint() {
		return endpoint;
	}

	@JsonProperty("endpoint")
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	@JsonProperty("auth")
	public String getAuth() {
		return auth;
	}

	@JsonProperty("auth")
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * Returns the base64 encoded auth string as a byte[]
	 */
	public byte[] getAuthAsBytes() {
		return Base64.getDecoder().decode(getAuth());
	}

	/**
	 * Returns the base64 encoded public key string as a byte[]
	 */
	public byte[] getKeyAsBytes() {
		return Base64.getDecoder().decode(getKey());
	}

	/**
	 * Returns the base64 encoded public key as a PublicKey object
	 */
	public PublicKey getUserPublicKey() throws NoSuchAlgorithmException,
			InvalidKeySpecException, NoSuchProviderException {
		KeyFactory kf = KeyFactory.getInstance("ECDH",
				BouncyCastleProvider.PROVIDER_NAME);
		ECNamedCurveParameterSpec ecSpec = ECNamedCurveTable
				.getParameterSpec("secp256r1");
		ECPoint point = ecSpec.getCurve().decodePoint(getKeyAsBytes());
		ECPublicKeySpec pubSpec = new ECPublicKeySpec(point, ecSpec);

		return kf.generatePublic(pubSpec);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}