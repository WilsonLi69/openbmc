#!/bin/sh

echo "Applying custom firewall rules..."

iptables -F

iptables -A INPUT -i lo -j ACCEPT

iptables -A INPUT -s @@WHITELIST_IP@@ -j ACCEPT

iptables -P INPUT DROP

echo "Firewall rules applied successfully."
