package denominator.model.rdata;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;
import java.util.Map;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;

/**
 * Corresponds to the binary representation of the {@code CNAME} (Canonical
 * Name) RData
 * 
 * <h4>Example</h4>
 * 
 * <pre>
 * CNAMEData rdata = CNAMEData.create("cname.foo.com.");
 * </pre>
 * 
 * @see <a href="http://www.ietf.org/rfc/rfc1035.txt">RFC 1035</a>
 */
public class CNAMEData extends ForwardingMap<String, Object> {

    public static CNAMEData create(String cname) {
        return new CNAMEData(cname);
    }

    @ConstructorProperties("cname")
    private CNAMEData(String cname) {
        this.delegate = ImmutableMap.<String, Object> of("cname", checkNotNull(cname, "cname"));
    }

    /**
     * domain-name which specifies the canonical or primary name for the owner.
     * The owner name is an alias.
     */
    public String getCname() {
        return get("cname").toString();
    }

    private final ImmutableMap<String, Object> delegate;
    
    @Override
    protected Map<String, Object> delegate() {
        return delegate;
    }
}
